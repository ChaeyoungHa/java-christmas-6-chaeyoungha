package christmas.ui.output;

import java.util.List;

public class OutputView {
    private static final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
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
