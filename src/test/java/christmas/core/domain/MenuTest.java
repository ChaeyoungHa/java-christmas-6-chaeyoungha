package christmas.core.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "해산물파스타", "초코케이크", "제로콜라", "레드와인"})
    void menuOf(String name) {
        Menu menu = assertDoesNotThrow(() -> Menu.of(name));

        assertThat(menu).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"버섯수프", "알리오올리오", "딸기케이크", "사이다", "맥주"})
    void noMenuOf(String name) {
        assertThatThrownBy(() -> Menu.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"초코케이크", "아이스크림"})
    void hasMenuCategoryOfDessert(String name) {
        // Given
        Menu testMenu = Menu.of(name);

        // When
        boolean result = testMenu.hasCategoryOf(MenuCategory.DESSERT);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"})
    void hasMenuCategoryOfMain(String name) {
        // Given
        Menu testMenu = Menu.of(name);

        // When
        boolean result = testMenu.hasCategoryOf(MenuCategory.MAIN);

        // Then
        assertThat(result).isEqualTo(true);
    }
}
