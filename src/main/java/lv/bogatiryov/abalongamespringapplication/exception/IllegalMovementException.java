package lv.bogatiryov.abalongamespringapplication.exception;

public class IllegalMovementException extends ValidateException {
    public IllegalMovementException(String message) {
        super(message);
    }

    public IllegalMovementException(ExceptionMessage message) {
        super(message);
    }

    public IllegalMovementException() {
        super("Illegal move error");
    }
}
