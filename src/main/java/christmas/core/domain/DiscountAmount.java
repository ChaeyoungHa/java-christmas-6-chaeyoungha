package christmas.core.domain;

@FunctionalInterface
public interface DiscountAmount {

    int calculate(Reservation reservation);
}
