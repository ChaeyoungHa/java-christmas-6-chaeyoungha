package christmas.ui.input;

import christmas.exception.ErrorType;
import christmas.exception.ReservationException;
import christmas.ui.output.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String MENU_REGEX = ".+-\\d+";

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
            return Arrays.stream(menuInput.split(",")).toList();
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
