package lv.bogatiryov.abalongamespringapplication.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class Movement {
    private Direction direction;
    private ArrayList<Field> fields; //TODO change to Set
    private Board board;
    private String playerId;

    public Movement(Direction direction, ArrayList<Field> fields, String playerId) {
        this.direction = direction;
        this.fields = fields;
        this.playerId = playerId;
    }
}
