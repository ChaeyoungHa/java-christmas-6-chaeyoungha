package christmas.core.domain;

public class WeekendDiscountAmount implements DiscountAmount {

    private static final int DISCOUNT_WEIGHT = 2023;

    @Override
    public int calculate(Reservation reservation) {
        return reservation.filterMenusByCategory(MenuCategory.MAIN).values().stream()
                .mapToInt(count -> count * DISCOUNT_WEIGHT)
                .sum();
    }
}
