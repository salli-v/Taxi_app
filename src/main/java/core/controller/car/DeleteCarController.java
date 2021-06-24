package core.controller.car;

import core.lib.Injector;
import core.service.CarService;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("core");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        carService.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect("/cars/all");
    }
}
