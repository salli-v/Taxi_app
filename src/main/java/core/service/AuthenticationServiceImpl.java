package core.service;

import core.dao.DriverDao;
import core.lib.Inject;
import core.lib.Service;
import core.lib.exception.AuthenticationException;
import core.model.Driver;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverDao driverDao;
    
    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driver = driverDao.findByLogin(login);
        if (driver.get().getPassword().equals(password)) {
            return driver.get();
        }
        if (driver.isEmpty()) {
            throw new AuthenticationException("Login or password is incorrect");
        }
        throw new AuthenticationException("Login or password is incorrect");
    }
}
