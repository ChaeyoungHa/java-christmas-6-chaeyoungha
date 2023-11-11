package christmas.ui.output;

public class OutputView {
    private static final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printHello() {
        System.out.println(HELLO);
    }
}
