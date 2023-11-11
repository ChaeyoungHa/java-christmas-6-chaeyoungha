package christmas.exception;

public enum ErrorType {
    INVALID_MENU_INPUT("주문하실 메뉴와 개수는 메뉴이름-숫자 형식으로 입력하고 쉼표를 통해 구분해야 합니다."),
    NOT_FOUND_MENU("존재하지 않는 메뉴입니다."),
    ;

    private final String message;

    ErrorType(String message) { this.message = message; }

    public String getMessage() { return message; }
}
