package christmas.core.domain;

public class GiveawayDiscountAmount implements DiscountAmount {

    @Override
    public int calculate(Reservation reservation) {
        if (reservation.priceBeforeDiscountExceeds(119999)) {
            return 25000;
        }

        return 0;
    }
}
