package christmas;

import christmas.core.controller.ReserveController;
import christmas.core.domain.Reservation;
import christmas.core.service.ReserveService;

public class Application {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();

        ReserveService reserveService = new ReserveService(reservation);

        ReserveController reserveController = new ReserveController(reserveService);

        reserveController.run();
    }
}
