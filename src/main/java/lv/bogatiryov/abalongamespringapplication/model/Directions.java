package lv.bogatiryov.abalongamespringapplication.model;

public enum Directions {
    TRUE(1,true),
    FALSE(-1,false);
    private final int direction;

    private final boolean statement;

    Directions(int direction, boolean statement) {
        this.direction = direction;
        this.statement = statement;
    }

    public int getDirection() {
        return direction;
    }
    public boolean isStatement() {
        return statement;
    }
}
