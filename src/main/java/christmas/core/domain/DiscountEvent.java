package christmas.core.domain;

public interface DiscountEvent {
    int calculateDiscountAmount(Reservation reservation);
}
