package christmas.core.domain;

public class SpecialDiscountAmount implements DiscountAmount {

    private static final int DEFAULT_DISCOUNT_AMOUNT = 1000;

    @Override
    public int calculate(Reservation reservation) {
        return DEFAULT_DISCOUNT_AMOUNT;
    }
}
