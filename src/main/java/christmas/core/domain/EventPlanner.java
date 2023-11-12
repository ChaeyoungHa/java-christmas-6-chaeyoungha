package christmas.core.domain;

import christmas.ui.output.OutputView;
import christmas.util.Formatter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class EventPlanner {
    private Reservation reservation;

    public EventPlanner() { }

    public void makeReservation(LocalDate date, HashMap<Menu, Integer> menus) {
        this.reservation = new Reservation(date, menus);
    }
}
