package christmas.core.domain;

public class WeekendDiscountAmount implements DiscountAmount {

    @Override
    public int calculate(Reservation reservation) {
        return reservation.filterMenusByCategory(MenuCategory.MAIN).values().stream()
                .mapToInt(count -> count * 2023)
                .sum();
    }
}
