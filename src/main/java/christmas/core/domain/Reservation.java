package christmas.core.domain;

import christmas.exception.ErrorType;
import christmas.exception.ReservationException;
import christmas.util.Calendar;
import christmas.util.Formatter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reservation {
    private static final String GIVEAWAY = "샴페인 1개";
    private static final String NO_ITEM = "없음";
    private static final int MAX_MENU_COUNT = 20;

    private final LocalDate date;
    private final HashMap<Menu, Integer> menus;
    private HashMap<DiscountEventImpl, Integer> discountEvents;
    private EventBadge eventBadge;

    public Reservation(LocalDate date, HashMap<Menu, Integer> menus) {
        this.date = date;

        validateMenus(menus);
        this.menus = menus;

        this.discountEvents = new HashMap<>();
        this.eventBadge = EventBadge.NONE;
    }

    public LocalDate getDate() {
        return date;
    }

    private Map<DiscountEventImpl, Integer> filterDiscountEvents() {
        return discountEvents.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public int calculatePriceBeforeDiscount() {
        return menus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int calculateGiveawayDiscount() {
        return discountEvents.get(DiscountEventImpl.GIVEAWAY_DISCOUNT);
    }

    public int calculateDiscountAmountSum() {
        return discountEvents.values().stream().mapToInt(value -> value).sum();
    }

    public String formatDate() {
        return Formatter.formatDate(date);
    }

    public List<String> formatMenus() {
        return Formatter.formatMenus(menus);
    }

    public String formatPriceBeforeDiscount() {
        return Formatter.formatPrice(calculatePriceBeforeDiscount());
    }

    public String formatGiveaway() {
        if(calculateGiveawayDiscount() == 0) {
            return NO_ITEM;
        }

        return GIVEAWAY;
    }

    public List<String> formatDiscountEvents() {
        if(calculateDiscountAmountSum() == 0) {
            return List.of(NO_ITEM);
        }

        return Formatter.formatDiscountEvents(filterDiscountEvents());
    }

    public String formatDiscountAmountSum() {
        return Formatter.formatDiscountAmount(calculateDiscountAmountSum());
    }

    public String formatPriceAfterDiscount() {
        return Formatter.formatPrice(calculatePriceAfterDiscount());
    }

    private int calculatePriceAfterDiscount() {
        int priceBeforeDiscount = calculatePriceBeforeDiscount();
        int discountAmountSum = calculateDiscountAmountSum();
        int giveawayDiscount = calculateGiveawayDiscount();

        return priceBeforeDiscount - discountAmountSum + giveawayDiscount;
    }

    public String getEventBadgeName() {
        return eventBadge.getName();
    }

    public void giveEventBadge() {
        eventBadge = EventBadge.of(calculateDiscountAmountSum());
    }

    public int calculateDifferenceFromFirstDay() {
        return date.getDayOfMonth() - Calendar.FIRST_DAY;
    }

    public Map<Menu, Integer> filterMenusByCategory(MenuCategory category) {
        return menus.entrySet().stream()
                .filter(entry -> entry.getKey().hasCategoryOf(category))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    public void applyAllDiscount() {
        discountEvents = new HashMap<>(calculateAllDiscount());
    }

    private Map<DiscountEventImpl, Integer> calculateAllDiscount() {
        return Arrays.stream(DiscountEventImpl.values())
                .collect(Collectors.toMap(
                        discountEvent -> discountEvent,
                        this::calculateDiscountForEvent
                ));
    }

    private int calculateDiscountForEvent(DiscountEventImpl discountEvent) {
        if(discountEvent.containsDateOf(this) && calculatePriceBeforeDiscount() > 10000) {
            return discountEvent.calculateDiscountAmount(this);
        }

        return 0;
    }

    private void validateMenus(HashMap<Menu, Integer> menus) {
        if(exceedsMaxMenuCount(menus)|| hasOnlyDrinkMenus(menus)) {
            throw ReservationException.of(ErrorType.INVALID_MENU_INPUT);
        }
    }

    private boolean exceedsMaxMenuCount(HashMap<Menu, Integer> menus) {
        return calculateAllMenuCount(menus) > MAX_MENU_COUNT;
    }

    private int calculateAllMenuCount(HashMap<Menu, Integer> menus) {
        return menus.values().stream()
                .mapToInt(count -> count)
                .sum();
    }

    public boolean hasOnlyDrinkMenus(HashMap<Menu, Integer> menus) {
        return menus.keySet().stream()
                .allMatch(menu -> menu.hasCategoryOf(MenuCategory.DRINK));
    }
}
