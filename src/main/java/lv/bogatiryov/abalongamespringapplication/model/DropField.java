package lv.bogatiryov.abalongamespringapplication.model;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@EqualsAndHashCode
public class DropField extends Field {
    private ArrayList<Ball> balls = new ArrayList<>();

    public DropField(int xCord, int yCord) {
        super(xCord, yCord);
    }
}
