package christmas.core.domain;

public class ChristmasDdayDiscountAmount implements DiscountAmount {

    @Override
    public int calculate(Reservation reservation) {
        return 1000 + reservation.calculateDifferenceFromFirstDay() * 100;
    }
}
