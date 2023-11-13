package christmas.core.domain;

import christmas.ui.output.OutputView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {

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
        if(discountEvent.containsDateOf(reservation)) {
            return discountEvent.calculateDiscountAmount(reservation);
        }

        return 0;
    }

    public void printReservationPreview() {
        printStartPreview();

        printMenus();

        printPriceBeforeDiscount();

        calculateAllDiscount();
        printGiveaway();
        printDiscountEvents();
        printDiscountAmountSum();
        printPriceAfterDiscount();

        printEventBade();
    }

    private void printStartPreview() {
        String date = reservation.formatDate();

        OutputView.printStartReservationPreview(date);
    }

    private void printMenus() {
        List<String> menus = reservation.formatMenus();

        OutputView.printMenus(menus);
    }

    private void printPriceBeforeDiscount() {
        String priceBeforeDiscount = reservation.formatPriceBeforeDiscount();

        OutputView.printPriceBeforeDiscount(priceBeforeDiscount);
    }

    private void printGiveaway() {
        String giveaway = reservation.formatGiveaway();

        OutputView.printGiveaway(giveaway);
    }

    private void printDiscountEvents() {
        List<String> discountEvents = reservation.formatDiscountEvents();

        OutputView.printDiscountEvents(discountEvents);
    }

    private void printDiscountAmountSum() {
        String discountAmountSum = reservation.formatDiscountAmountSum();

        OutputView.printDiscountAmountSum(discountAmountSum);
    }

    private void printPriceAfterDiscount() {
        String priceAfterDiscount = reservation.formatPriceAfterDiscount();

        OutputView.printPriceAfterDiscount(priceAfterDiscount);
    }

    private void printEventBade() {
        String eventBadge = reservation.formatEventBadge();

        OutputView.printEventBadge(eventBadge);
    }
}
