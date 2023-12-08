package christmas.core.domain;

public class DiscountAmountOfThisYear implements DiscountAmount {

    private static final int DISCOUNT_WEIGHT_OF_THIS_YEAR = 2023;
    private final MenuCategory menuCategory;

    public DiscountAmountOfThisYear(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    @Override
    public int calculate(Reservation reservation) {
        return reservation.filterMenusByCategory(menuCategory).values().stream()
                .mapToInt(count -> count * DISCOUNT_WEIGHT_OF_THIS_YEAR)
                .sum();
    }
}
