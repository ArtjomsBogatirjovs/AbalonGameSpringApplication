package lv.bogatiryov.abalongamespringapplication.model;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = false)
public class DropField extends Field {
    private ArrayList<Ball> balls = new ArrayList<>();

    public DropField(int xCord, int yCord) {
        super(xCord, yCord);
    }
}
