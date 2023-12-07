package christmas.core.domain;

public class WeekdayDiscountAmount implements DiscountAmount {

    @Override
    public int calculate(Reservation reservation) {
        return reservation.filterMenusByCategory(MenuCategory.DESSERT).values().stream()
                .mapToInt(count -> count * 2023)
                .sum();
    }
}
