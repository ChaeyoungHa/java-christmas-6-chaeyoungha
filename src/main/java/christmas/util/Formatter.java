package christmas.util;

import christmas.core.domain.DiscountEventImpl;
import christmas.core.domain.Menu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    private static final String DATE_FORMAT = "MM월 dd일";
    private static final String MENU_FORMAT = "%s %d개";
    private static final String PRICE_FORMAT = "#,##0원";
    private static final String MINUS = "-";
    private static final String DISCOUNT_EVENT_FORMAT = "%s: %s";

    public static String formatDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        return date.format(dateTimeFormatter);
    }

    public static List<String> formatMenus(HashMap<Menu, Integer> menus) {
        return menus.entrySet().stream()
                .map(entry -> String.format(MENU_FORMAT, entry.getKey().getName(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static String formatPrice(int price) {
        DecimalFormat priceFormat = new DecimalFormat(PRICE_FORMAT);

        return priceFormat.format(price);
    }

    public static List<String> formatDiscountEvents(HashMap<DiscountEventImpl, Integer> discountEvents) {
        return discountEvents.entrySet().stream()
                .map(entry -> String.format(DISCOUNT_EVENT_FORMAT, entry.getKey().getName(), MINUS + formatPrice(entry.getValue())))
                .collect(Collectors.toList());
    }
}
