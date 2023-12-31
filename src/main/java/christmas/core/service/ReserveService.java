package christmas.core.service;

import christmas.core.domain.EventPlanner;
import christmas.core.domain.Menu;
import java.time.LocalDate;
import java.util.HashMap;

public class ReserveService {
    private final EventPlanner eventPlanner;

    public ReserveService() {
        this.eventPlanner = new EventPlanner();
    }

    public void reserve(LocalDate date, HashMap<Menu, Integer> menus) {
        eventPlanner.makeReservation(date, menus);
    }

    public void showReservationPreview() {
        eventPlanner.printReservationBasicInformation();

        eventPlanner.printReservationDiscountDetails();

        eventPlanner.printEventBadge();
    }
}
