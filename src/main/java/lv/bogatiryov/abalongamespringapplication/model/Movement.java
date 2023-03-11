package lv.bogatiryov.abalongamespringapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@Setter
@Getter
public class Movement {
    private Direction direction;
    private ArrayList<Field> fields;
    private String text;
    private String playerId;
}
