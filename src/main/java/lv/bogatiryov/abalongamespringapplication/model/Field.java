package lv.bogatiryov.abalongamespringapplication.model;

public class Field{
    private Ball ball;
    private final int xCord;
    private final int yCord;

    public Field(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public Field(Ball ball, int xCord, int yCord) {
        this.ball = ball;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public int getXCord() {
        return xCord;
    }

    public int getYCord() {
        return yCord;
    }
}
