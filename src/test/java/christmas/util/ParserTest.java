package christmas.util;

import christmas.core.domain.Menu;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static christmas.util.Calendar.DEFAULT_MONTH;
import static christmas.util.Calendar.DEFAULT_YEAR;
import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    @Test
    void parseDateInput() {
        // Given
        String testInput = "10";

        // When
        LocalDate result = Parser.parseDateInput(testInput);

        // Then
        assertThat(result).isEqualTo(LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, 10));
    }

    @Test
    void parseDateInputNotNumber() {
        // Given
        String testInput = "1안녕하세요?";

        // When & Then
        assertThatThrownBy(() -> Parser.parseDateInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseDateInputNotExistInCalendar() {
        // Given
        String testInput = "32";

        // When & Then
        assertThatThrownBy(() -> Parser.parseDateInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseDateInputWithBlank() {
        // Given
        String testInput = "10 ";

        // When & Then
        assertThatThrownBy(() -> Parser.parseDateInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseMenuInput() {
        // Given
        String testInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        // When
        HashMap<Menu, Integer> result = Parser.parseMenuInput(testInput);

        //Then
        assertThat(result).isEqualTo(Map.ofEntries(
                entry(Menu.T_BONE_STEAK, 1),
                entry(Menu.BARBECUE_RIBS, 1),
                entry(Menu.CHOCOLATE_CAKE, 2),
                entry(Menu.ZERO_COKE, 1)
        ));
    }

    @Test
    void parseMenuInputWithoutDelimiter() {
        // Given
        String testInput = "티본스테이크-1바비큐립-1초코케이크-2";

        // When & Then
        assertThatThrownBy(() -> Parser.parseMenuInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseMenuInputInvalidPairFormat() {
        // Given
        String testInput = "티본스테이크:1,바비큐립:1,초코케이크:2";

        // When & Then
        assertThatThrownBy(() -> Parser.parseMenuInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseMenuInputLessThanOne() {
        // Given
        String testInput = "티본스테이크-3,바비큐립-2,초코케이크-0";

        // When & Then
        assertThatThrownBy(() -> Parser.parseMenuInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseMenuInputDuplicate() {
        // Given
        String testInput = "초코케이크-1,티본스테이크-3,초코케이크-2";

        // When & Then
        assertThatThrownBy(() -> Parser.parseMenuInput(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
