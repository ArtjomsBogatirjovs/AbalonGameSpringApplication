package lv.bogatiryov.abalongamespringapplication.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }
}
