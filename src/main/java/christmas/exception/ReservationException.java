package christmas.exception;

public class ReservationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public ReservationException(ErrorType errorType) {
        super(ERROR_MESSAGE_PREFIX + errorType.getMessage());
    }

    public static ReservationException of(ErrorType errorType) { return  new ReservationException(errorType); }
}
