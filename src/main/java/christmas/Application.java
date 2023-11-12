package christmas;

import christmas.core.controller.ReserveController;
import christmas.core.service.ReserveService;

public class Application {
    public static void main(String[] args) {
        ReserveService reserveService = new ReserveService();

        ReserveController reserveController = new ReserveController(reserveService);

        reserveController.run();
    }
}
