package lv.bogatiryov.abalongamespringapplication.service;

import lv.bogatiryov.abalongamespringapplication.db.domain.Direction;
import lv.bogatiryov.abalongamespringapplication.enums.DirectionType;
import lv.bogatiryov.abalongamespringapplication.enums.Directions;
import org.springframework.stereotype.Service;

@Service
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