package core.service;

import core.lib.exception.AuthenticationException;
import core.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
