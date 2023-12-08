package christmas.core.domain;

public class WeekdayDiscountAmount implements DiscountAmount {

    private static final int DISCOUNT_WEIGHT = 2023;

    @Override
    public int calculate(Reservation reservation) {
        return reservation.filterMenusByCategory(MenuCategory.DESSERT).values().stream()
                .mapToInt(count -> count * DISCOUNT_WEIGHT)
                .sum();
    }
}
