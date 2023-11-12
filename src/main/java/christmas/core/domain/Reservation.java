package christmas.core.domain;

import java.time.LocalDate;
import java.util.HashMap;

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

    public void setDiscountEvents(HashMap<DiscountEventImpl, Integer> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public int calculatePriceBeforeDiscount() {
        return menus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
