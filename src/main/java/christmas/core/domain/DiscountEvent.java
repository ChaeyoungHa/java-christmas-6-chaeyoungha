package christmas.core.domain;

public interface DiscountEvent {
    abstract int discountAmount(Reservation reservation);
}
