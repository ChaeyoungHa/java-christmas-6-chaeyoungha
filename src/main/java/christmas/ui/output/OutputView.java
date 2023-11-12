package christmas.ui.output;

import java.util.List;

public class OutputView {
    private static final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String THIS_IS_RESERVATION_PREVIEW = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String THESE_ARE_MENUS = "<주문 메뉴>";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printHello() {
        System.out.println(HELLO);
    }

    public static void printStartReservationPreview(String date) {
        System.out.println(date + THIS_IS_RESERVATION_PREVIEW);
        System.out.println();
    }

    public static void printMenus(List<String> menus) {
        System.out.println(THESE_ARE_MENUS);

        menus.forEach(System.out::println);
    }
}
