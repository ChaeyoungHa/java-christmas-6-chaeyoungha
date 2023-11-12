package christmas.util;

import christmas.core.domain.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    private static final String DATE_FORMAT = "MM월 dd일";
    private static final String MENU_FORMAT = "%s %d개";

    public static String formatDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        return date.format(dateTimeFormatter);
    }

    public static List<String> formatMenus(HashMap<Menu, Integer> menus) {
        return menus.entrySet().stream()
                .map(entry -> String.format(MENU_FORMAT, entry.getKey().getName(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
