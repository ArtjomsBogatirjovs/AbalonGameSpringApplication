package lv.bogatiryov.abalongamespringapplication.model;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode
public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }
}
