package lv.bogatiryov.abalongamespringapplication.service;


import lv.bogatiryov.abalongamespringapplication.model.Direction;
import lv.bogatiryov.abalongamespringapplication.model.DirectionType;
import lv.bogatiryov.abalongamespringapplication.model.Field;
import lv.bogatiryov.abalongamespringapplication.model.Movement;

import java.util.ArrayList;

public class MovementService {
    Field getLastFieldInChain(Movement move) {
        DirectionService dService = new DirectionService();
        BoardService bService = new BoardService();

        Direction direction = move.getDirection();
        ArrayList<Field> fields = move.getFields();

        int dirX = dService.getDirection(direction, DirectionType.X) * -1;
        int dirY = dService.getDirection(direction, DirectionType.Y) * -1;

        for (Field field : fields) {
            if(bService.findField(field.getXCord() + dirX, field.getYCord()+ dirY,fields ) == null){
                return field;
            }
        }
        return null;
    }
}
