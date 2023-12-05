package christmas.util;

import christmas.core.domain.Menu;
import christmas.exception.ErrorType;
import christmas.exception.ReservationException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Parser {
    private static final String MENU_INPUT_DELIMITER = ",";
    private static final String MENU_ITEM_DELIMITER = "-";

    public static LocalDate parseDateInput(String dateInput) {
        try {
            int date = Integer.parseInt(dateInput);

            return Calendar.generateDate(date);
        } catch (NumberFormatException | DateTimeException e) {
            throw ReservationException.of(ErrorType.INVALID_DATE_INPUT);
        }
    }

    public static HashMap<Menu, Integer> parseMenuInput(String menuInput) {
        try {
            List<String> menus = Arrays.stream(menuInput.split(MENU_INPUT_DELIMITER)).toList();

            return new HashMap<>(parseEachMenu(menus));
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw ReservationException.of(ErrorType.INVALID_MENU_INPUT);
        }
    }

    private static Map<Menu, Integer> parseEachMenu(List<String> menus) {
        return menus.stream()
                .map(menuItem -> menuItem.split(MENU_ITEM_DELIMITER))
                .collect(Collectors.toMap(
                        parts -> Menu.of(parts[0]),
                        parts -> {
                            int count = Integer.parseInt(parts[1]);

                            validateMenuCount(count);

                            return count;
                        },
                        validateMenuName
                        )
                );
    }

    private static void validateMenuCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }
    
    private static final BinaryOperator<Integer> validateMenuName = (oldValue, newValue) -> {
        throw new IllegalArgumentException();
    };
}
