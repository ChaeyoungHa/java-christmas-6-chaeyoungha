package christmas.core.domain;

public class GiveawayDiscountAmount implements DiscountAmount {

    private static final int MIN_ORDER_AMOUNT_BEFORE_DISCOUNT = 119999;
    private static final int DEFAULT_DISCOUNT_AMOUNT = 25000;
    private static final int NO_DISCOUNT = 0;

    @Override

    public int calculate(Reservation reservation) {
        if (reservation.priceBeforeDiscountExceeds(MIN_ORDER_AMOUNT_BEFORE_DISCOUNT)) {
            return DEFAULT_DISCOUNT_AMOUNT;
        }

        return NO_DISCOUNT;
    }
}
