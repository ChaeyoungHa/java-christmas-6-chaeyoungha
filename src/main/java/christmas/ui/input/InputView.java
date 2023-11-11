package christmas.ui.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.ui.output.OutputView;

public class InputView {
    private static final String WHEN_IS_THE_DATE_TO_VISIT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static String readDate() {
        OutputView.print(WHEN_IS_THE_DATE_TO_VISIT);

        return Console.readLine();
    }
}
