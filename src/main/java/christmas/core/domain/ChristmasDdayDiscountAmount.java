package christmas.core.domain;

public class ChristmasDdayDiscountAmount implements DiscountAmount {

    private static final int MIN_DISCOUNT_AMOUNT = 1000;
    private static final int DISCOUNT_WEIGHT = 100;

    @Override

    public int calculate(Reservation reservation) {
        return MIN_DISCOUNT_AMOUNT + reservation.calculateDifferenceFromFirstDay() * DISCOUNT_WEIGHT;
    }
}
