package christmas.core.domain;

import static christmas.util.Calendar.CHRISTMAS_DAY;
import static christmas.util.Calendar.DEFAULT_MONTH;
import static christmas.util.Calendar.DEFAULT_YEAR;
import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ReservationTest {

    @Test
    void createReservationWithOnlyDrinkMenus() {
        // Given
        LocalDate testDate = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, CHRISTMAS_DAY);
        HashMap<Menu, Integer> testMenus = new HashMap<>(Map.ofEntries(
                entry(Menu.ZERO_COKE, 1),
                entry(Menu.RED_WINE, 2),
                entry(Menu.CHAMPAGNE, 3)
        ));

        // When & Then
        assertThatThrownBy(() -> new Reservation(testDate, testMenus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createReservationMoreThanMaxMenuCount() {
        // Given
        LocalDate testDate = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, CHRISTMAS_DAY);
        HashMap<Menu, Integer> testMenus = new HashMap<>(Map.ofEntries(
                entry(Menu.ZERO_COKE, 9),
                entry(Menu.RED_WINE, 10),
                entry(Menu.CHAMPAGNE, 11)
        ));

        // When & Then
        assertThatThrownBy(() -> new Reservation(testDate, testMenus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
