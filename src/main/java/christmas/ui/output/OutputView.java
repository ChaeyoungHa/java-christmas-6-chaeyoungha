package christmas.ui.output;

import java.util.List;

public class OutputView {
    private static final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String THIS_IS_EVENT_GUIDE = """
            *************************  안내 사항  *************************
            * 총 주문 금액 10,000원 이상부터 할인 이벤트가 적용됩니다.
            * 음료 메뉴만 주문할 수 없습니다.
            * 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
            * 이벤트 혜택은 중복 적용될 수 있습니다.
            * 총 혜택 금액에 따라 다른 이벤트 배지가 부여됩니다.
            * 배지에 따라 2024 새해 이벤트에서 각각 다른 새해 선물을 증정할 예정입니다.
            ************************************************************
            """;
    private static final String THIS_IS_RESERVATION_PREVIEW = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String THESE_ARE_MENUS = "<주문 메뉴>";
    private static final String THIS_IS_PRICE_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String THIS_IS_GIVEAWAY = "<증정 메뉴>";
    private static final String THESE_ARE_DISCOUNT_EVENTS = "<혜택 내역>";
    private static final String THIS_IS_DISCOUNT_AMOUNT_SUM = "<총혜택 금액>";
    private static final String THIS_IS_PRICE_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String THIS_IS_EVENT_BADGE = "<12월 이벤트 배지>";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printHello() {
        System.out.println(HELLO);
    }

    public static void printEventGuide() {
        System.out.println(THIS_IS_EVENT_GUIDE);
    }

    public static void printStartReservationPreview(String date) {
        System.out.println(date + THIS_IS_RESERVATION_PREVIEW);
        System.out.println();
    }

    public static void printMenus(List<String> menus) {
        System.out.println(THESE_ARE_MENUS);
        menus.forEach(System.out::println);
        System.out.println();
    }

    public static void printPriceBeforeDiscount(String priceBeforeDiscount) {
        System.out.println(THIS_IS_PRICE_BEFORE_DISCOUNT);
        System.out.println(priceBeforeDiscount);
        System.out.println();
    }

    public static void printGiveaway(String giveaway) {
        System.out.println(THIS_IS_GIVEAWAY);
        System.out.println(giveaway);
        System.out.println();
    }

    public static void printDiscountEvents(List<String> discountEvents) {
        System.out.println(THESE_ARE_DISCOUNT_EVENTS);
        discountEvents.forEach(System.out::println);
        System.out.println();
    }

    public static void printDiscountAmountSum(String discountAmountSum) {
        System.out.println(THIS_IS_DISCOUNT_AMOUNT_SUM);
        System.out.println(discountAmountSum);
        System.out.println();
    }

    public static void printPriceAfterDiscount(String price) {
        System.out.println(THIS_IS_PRICE_AFTER_DISCOUNT);
        System.out.println(price);
        System.out.println();
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println(THIS_IS_EVENT_BADGE);
        System.out.println(eventBadge);
    }
}
