package christmas.core.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {
    @ParameterizedTest
    @ValueSource(ints = {-100, 100, 1000, 4999})
    void eventBadgeOfNone(int discountAmountSum) {
        // Given & When
        EventBadge result = EventBadge.of(discountAmountSum);

        // Then
        assertThat(result).isEqualTo(EventBadge.NONE);
    }

    @ParameterizedTest
    @ValueSource(ints = {5000, 6000, 9999})
    void eventBadgeOfStar(int discountAmountSum) {
        // Given & When
        EventBadge result = EventBadge.of(discountAmountSum);

        // Then
        assertThat(result).isEqualTo(EventBadge.STAR);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 19999})
    void eventBadgeOfTree(int discountAmountSum) {
        // Given & When
        EventBadge result = EventBadge.of(discountAmountSum);

        // Then
        assertThat(result).isEqualTo(EventBadge.TREE);
    }

    @ParameterizedTest
    @ValueSource(ints = {20000, 50000, 100000})
    void eventBadgeOfSanta(int discountAmountSum) {
        // Given & When
        EventBadge result = EventBadge.of(discountAmountSum);

        // Then
        assertThat(result).isEqualTo(EventBadge.SANTA);
    }
}
