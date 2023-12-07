package christmas.core.domain;

public class SpecialDiscountAmount implements DiscountAmount {

    @Override
    public int calculate(Reservation reservation) {
        return 1000;
    }
}
