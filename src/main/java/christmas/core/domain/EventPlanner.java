package christmas.core.domain;

import christmas.ui.output.OutputView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class EventPlanner {

    private Reservation reservation;

    public EventPlanner() { }

    public void makeReservation(LocalDate date, HashMap<Menu, Integer> menus) {
        this.reservation = new Reservation(date, menus);
    }

    public void printReservationDiscountDetails() {
        reservation.applyAllDiscount();

        printGiveaway();
        printDiscountEvents();
        printDiscountAmountSum();
        printPriceAfterDiscount();
    }

    public void printReservationBasicInformation() {
        printStartPreview();

        printMenus();

        printPriceBeforeDiscount();
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

    public void printEventBadge() {
        reservation.giveEventBadge();

        String eventBadge = reservation.getEventBadgeName();

        OutputView.printEventBadge(eventBadge);
    }
}
