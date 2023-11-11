package christmas.ui.input;

import christmas.exception.ErrorType;
import christmas.exception.ReservationException;
import christmas.ui.output.OutputView;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int DEFAULT_YEAR = 2023;
    private static final int DEFAULT_MONTH = 12;
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String MENU_REGEX = ".+-\\d+";

    public static boolean isValidDateInput(String dateInput) {
        try {
            int date = dateInputParser(dateInput);
            validateDate(date);

            return true;
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            return false;
        }
    }

    private static Integer dateInputParser(String dateInput) {
        try {
            return Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            throw ReservationException.of(ErrorType.INVALID_DATE_INPUT);
        }
    }

    private static void validateDate(int date) {
        try {
            LocalDate fullDate = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, date);
        } catch (DateTimeException e) {
            throw ReservationException.of(ErrorType.INVALID_DATE_INPUT);
        }
    }

    public static boolean isValidMenuInput(String menuInput) {
        try {
            List<String> menus = menuInputParser(menuInput);
            validateEachMenu(menus);

            return true;
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            return false;
        }
    }

    public static List<String> menuInputParser(String menuInput) {
        try {
            return Arrays.stream(menuInput.split(DEFAULT_SEPARATOR)).toList();
        } catch (Exception e) {
            throw ReservationException.of(ErrorType.INVALID_MENU_INPUT);
        }
    }

    public static void validateEachMenu(List<String> menus) {
        Pattern menuPattern = Pattern.compile(MENU_REGEX);

        if (menus.stream().anyMatch(menu -> !menuPattern.matcher(menu).matches())) {
            throw ReservationException.of(ErrorType.INVALID_MENU_INPUT);
        }
    }
}
