package christmas.core.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reservation {
    private LocalDate date;
    private HashMap<Menu, Integer> menus;
    private HashMap<DiscountEventImpl, Integer> discountEvents;
    private EventBadge eventBadge;

    public Reservation(LocalDate date, HashMap<Menu, Integer> menus) {
        this.date = date;
        this.menus = menus;
        this.discountEvents = new HashMap<>();
        this.eventBadge = EventBadge.NONE;
    }

    public LocalDate getDate() {
        return date;
    }

    public HashMap<Menu, Integer> getMenus() {
        return menus;
    }

    public HashMap<DiscountEventImpl, Integer> getDiscountEvents() {
        return discountEvents;
    }

    public void setDiscountEvents(HashMap<DiscountEventImpl, Integer> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public HashMap<DiscountEventImpl, Integer> getDiscountEventsExceptNoDiscount() {
        return discountEvents.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existing, replacement) -> existing,
                        HashMap::new));
    }

    public int calculatePriceBeforeDiscount() {
        return menus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int calculateAllDiscountAmount() {
        return discountEvents.values().stream().mapToInt(value -> value).sum();
    }
}
