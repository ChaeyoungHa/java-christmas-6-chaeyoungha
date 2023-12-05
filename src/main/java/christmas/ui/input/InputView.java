package christmas.ui.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.ui.output.OutputView;

public class InputView {

    private static final String WHEN_IS_THE_DATE_TO_VISIT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String WHAT_MENU_TO_ORDER_AND_HOW_MANY = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,"
            + "초코케이크-1)";

    public static String readDate() {
        OutputView.print(WHEN_IS_THE_DATE_TO_VISIT);

        return Console.readLine();
    }

    public static String readMenus() {
        OutputView.print(WHAT_MENU_TO_ORDER_AND_HOW_MANY);

        return Console.readLine();
    }
}
