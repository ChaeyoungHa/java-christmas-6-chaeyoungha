package christmas.core.domain;

import static christmas.util.Calendar.DEFAULT_MONTH;
import static christmas.util.Calendar.DEFAULT_YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountEventTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 21, 25})
    void christmasDdayDiscountContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.CHRISTMAS_DDAY_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28, 29, 30, 31})
    void christmasDdayDiscountNotContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.CHRISTMAS_DDAY_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13, 14})
    void weekdayDiscountContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.WEEKDAY_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 16})
    void weekdayDiscountNotContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.WEEKDAY_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 16})
    void weekendDiscountContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.WEEKEND_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13, 14})
    void weekendDiscountNotContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.WEEKEND_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void specialDiscountContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.SPECIAL_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 11, 18, 26, 30})
    void specialDiscountNotContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.SPECIAL_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 21, 31})
    void giveawayDiscountContainsDateOf(int day) {
        // Given
        LocalDate testInput = LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);

        // When
        boolean result = DiscountEvent.GIVEAWAY_DISCOUNT.containsDateOf(testInput);

        // Then
        assertThat(result).isEqualTo(true);
    }
}
