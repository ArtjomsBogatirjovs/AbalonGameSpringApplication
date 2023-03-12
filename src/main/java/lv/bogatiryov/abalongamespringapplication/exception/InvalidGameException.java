package lv.bogatiryov.abalongamespringapplication.exception;

public class InvalidGameException extends ValidateException{

    public InvalidGameException(String message) {
        super(message);
    }

    public InvalidGameException(ExceptionMessage message) {
        super(message);
    }

    public InvalidGameException() {
        super("Invalid game error");
    }
}
