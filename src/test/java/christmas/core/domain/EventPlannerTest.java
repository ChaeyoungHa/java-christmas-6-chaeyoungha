package christmas.core.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

class EventPlannerTest {
    private EventPlanner eventPlanner;

    private PrintStream standardOut;
    private OutputStream outputStream;

    @BeforeEach
    protected final void init() {
        eventPlanner = new EventPlanner();

        LocalDate date = LocalDate.of(2023, 12, 3);
        HashMap<Menu, Integer> menus = new HashMap<>(Map.ofEntries(
                entry(Menu.T_BONE_STEAK, 1),
                entry(Menu.BARBECUE_RIBS, 1),
                entry(Menu.CHOCOLATE_CAKE, 2),
                entry(Menu.ZERO_COKE, 1)
        ));

        eventPlanner.makeReservation(date, menus);

        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected final void setOut() {
        System.setOut(standardOut);
    }

    protected final String output() {
        return outputStream.toString().trim();
    }

    @Test
    void printReservationBasicInformation() {
        // Given & When
        eventPlanner.printReservationBasicInformation();

        // Then
        assertThat(output()).contains(
                "12월 3일",
                "<주문 메뉴>",
                "초코케이크 2개",
                "바비큐립 1개",
                "티본스테이크 1개",
                "제로콜라 1개",
                "<할인 전 총주문 금액>",
                "142,000원"
        );
    }

    @Test
    void printReservationDiscountDetails() {
        // Given & When
        eventPlanner.printReservationDiscountDetails();

        // Then
        assertThat(output()).contains(
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원",
                "<총혜택 금액>",
                "-31,246원",
                "<할인 후 예상 결제 금액>",
                "135,754원"
        );
    }

    @Test
    void printEventBadgeBeforePrintReservationDiscountDetails() {
        // Given & When
        eventPlanner.printReservationDiscountDetails();
        eventPlanner.printEventBadge();

        // Then
        assertThat(output()).contains(
                "<12월 이벤트 배지>",
                "산타"
        );
    }

    @Test
    void printEventBadgeAfterPrintReservationDiscountDetails() {
        // Given & When
        eventPlanner.printEventBadge();

        // Then
        assertThat(output()).contains(
                "<12월 이벤트 배지>",
                "없음"
        );
    }
}
