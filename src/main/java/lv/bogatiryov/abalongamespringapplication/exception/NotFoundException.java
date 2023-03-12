package lv.bogatiryov.abalongamespringapplication.exception;

public class NotFoundException extends ValidateException {
    public NotFoundException() {
        super("Not found error!");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(ExceptionMessage message) {
        super(message);
    }
}
