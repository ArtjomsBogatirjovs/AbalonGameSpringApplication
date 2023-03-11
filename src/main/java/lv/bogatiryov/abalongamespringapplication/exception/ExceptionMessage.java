package lv.bogatiryov.abalongamespringapplication.exception;

public enum ExceptionMessage {
    NOT_FOUND("Game not created before, please create new game"),
    ONLY_ONE_PLAYER("Second player not added"),
    FINISHED("Game was already finished!"),
    IS_FULL("The game is full");
    private final String message;
    ExceptionMessage(String aMessage) {
        message = aMessage;
    }
    public String getMessage() {
        return message;
    }
}
