package christmas.exception;

public enum ErrorType {
    INVALID_DATE_INPUT("방문할 날짜는 1이상 31 이상의 숫자여야 합니다."),
    INVALID_MENU_INPUT("주문하실 메뉴와 개수는 메뉴이름-숫자 형식이고, 쉼표를 통해 구분되어야 합니다."),
    NOT_FOUND_MENU("존재하지 않는 메뉴입니다."),
    ;

    private final String message;

    ErrorType(String message) { this.message = message; }

    public String getMessage() { return message; }
}
