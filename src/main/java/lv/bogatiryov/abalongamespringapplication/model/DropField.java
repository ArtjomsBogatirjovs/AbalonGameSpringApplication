package lv.bogatiryov.abalongamespringapplication.model;

import java.util.ArrayList;

public class DropField extends Field {
    private ArrayList<Ball> balls = new ArrayList<>();

    public DropField(int xCord, int yCord) {
        super(xCord, yCord);
    }
}
