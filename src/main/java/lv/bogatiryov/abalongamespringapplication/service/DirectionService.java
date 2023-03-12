package lv.bogatiryov.abalongamespringapplication.service;

import lv.bogatiryov.abalongamespringapplication.model.Direction;
import lv.bogatiryov.abalongamespringapplication.model.DirectionType;
import lv.bogatiryov.abalongamespringapplication.model.Directions;

public class DirectionService {
    public int getDirection(Direction direction, DirectionType type) {
        Boolean isDir = type.equals(DirectionType.X) ? direction.getX() : direction.getY();
        int dir = Directions.NULL.getDirection();
        if (isDir != null) {
            if (isDir) {
                dir = Directions.TRUE.getDirection();
            } else {
                dir = Directions.FALSE.getDirection();
            }
        }
        return dir;
    }
}