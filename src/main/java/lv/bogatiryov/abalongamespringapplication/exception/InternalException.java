package lv.bogatiryov.abalongamespringapplication.exception;

public class InternalException extends RuntimeException{
    public InternalException() {
    }

    public InternalException(String message) {
        super(message);
    }
    public InternalException(ExceptionMessage message) {
        super(message.getMessage());
    }
}
