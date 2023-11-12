package christmas.core.domain;

import christmas.ui.output.OutputView;
import christmas.util.Formatter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    private static final String GIVEAWAY = "샴페인 1개";
    private static final String NO_DISCOUNT = "없음";
    private Reservation reservation;

    public EventPlanner() { }

    public void makeReservation(LocalDate date, HashMap<Menu, Integer> menus) {
        this.reservation = new Reservation(date, menus);
    }

    private void calculateAllDiscount() {
        HashMap<DiscountEventImpl, Integer> discountEvents = Arrays.stream(DiscountEventImpl.values())
                .collect(Collectors.toMap(
                        discountEvent -> discountEvent,
                        this::calculateDiscoutForEvent,
                        (existing, replacement) -> existing,
                        HashMap::new
                ));

        reservation.setDiscountEvents(discountEvents);
    }

    private int calculateDiscoutForEvent(DiscountEventImpl discountEvent) {
        if(discountEvent.getTargetDates().contains(reservation.getDate())) {
            return discountEvent.discountAmount(reservation);
        }

        return 0;
    }

    public void printReservationPreview() {
        printStartPreview();

        printMenus();

        printPriceBeforeDiscount();

        calculateAllDiscount();
        printGiveaway();
    }

    private void printStartPreview() {
        String date = Formatter.formatDate(reservation.getDate());
        OutputView.printStartReservationPreview(date);
    }

    private void printMenus() {
        List<String> menus = Formatter.formatMenus(reservation.getMenus());
        OutputView.printMenus(menus);
    }

    private void printPriceBeforeDiscount() {
        String priceBeforeDiscount = Formatter.formatPrice(reservation.calculatePriceBeforeDiscount());
        OutputView.printPriceBeforeDiscount(priceBeforeDiscount);
    }

    private void printGiveaway() {
        String giveaway = NO_DISCOUNT;

        int discountAmount = reservation.getDiscountEvents().get(DiscountEventImpl.GIVEAWAY_DISCOUNT);
        if(discountAmount != 0) {
            giveaway = GIVEAWAY;
        }

        OutputView.printGiveaway(giveaway);
    }
}
