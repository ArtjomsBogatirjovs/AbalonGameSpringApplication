package lv.bogatiryov.abalongamespringapplication.validator;

import lv.bogatiryov.abalongamespringapplication.db.domain.Board;
import lv.bogatiryov.abalongamespringapplication.db.domain.Direction;
import lv.bogatiryov.abalongamespringapplication.db.domain.Field;
import lv.bogatiryov.abalongamespringapplication.db.domain.Movement;
import lv.bogatiryov.abalongamespringapplication.enums.DirectionType;
import lv.bogatiryov.abalongamespringapplication.exception.ExceptionMessage;
import lv.bogatiryov.abalongamespringapplication.exception.IllegalMovementException;
import lv.bogatiryov.abalongamespringapplication.service.BoardService;
import lv.bogatiryov.abalongamespringapplication.service.DirectionService;
import lv.bogatiryov.abalongamespringapplication.service.FieldService;
import lv.bogatiryov.abalongamespringapplication.exception.InternalException;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovementValidator implements Validatable<Movement> {
    public final static int MAX_MOVEMENT_FIELD_AMOUNT = 3;
    public final static int MIN_BALLS_TO_SUMITO = 2;

    @Override
    public void validate(Movement move) {
        FieldService fieldService = new FieldService();
        Set<Field> fieldsToMove = move.getFields();

        if (fieldsToMove == null || fieldsToMove.isEmpty() || fieldsToMove.size() > MAX_MOVEMENT_FIELD_AMOUNT) {
            throw new IllegalMovementException(ExceptionMessage.WRONG_AMOUNT);
        }
        if (isMovementEmpty(move)) {
            throw new IllegalMovementException(ExceptionMessage.FIELD_WO_BALL);
        }
        if (!fieldService.isRow(fieldsToMove)) {
            throw new IllegalMovementException(ExceptionMessage.NOT_ROW);
        }
        if ((!isSumito(move) && isNeedToMoveBall(move))) {
            throw new IllegalMovementException(ExceptionMessage.CANT_MOVE);
        }
        if (!isPossibleToMoveOpponent(move)) {
            throw new IllegalMovementException(ExceptionMessage.CANT_MOVE);
        }
    }

    public boolean isSumito(Movement move) {
        Set<Field> fields = move.getFields();
        if (fields.size() < MIN_BALLS_TO_SUMITO) {
            return false;
        }
        if (!isDirectionLikeRow(move)) {
            return false;
        }
        return isNeedToMoveBall(move);
    }

    public boolean isPossibleToMoveOpponent(Movement move) {//TODO make BallCounterService
        if (!isSumito(move)) {
            return false;
        }
        BoardService bService = new BoardService();
        DirectionService dService = new DirectionService();

        Board board = move.getBoard();
        Field[][] gameBoard = board.getGameBoard();

        Set<Field> boardSet = bService.boardToFieldList(gameBoard);
        ArrayList<Field> boardAsList = new ArrayList<>(List.copyOf(boardSet));
        Set<Field> fieldsSet = move.getFields();
        ArrayList<Field> fields = new ArrayList<>(List.copyOf(fieldsSet));

        int maxMoveBall = fields.size() - 1;
        int ballToMove = 0;
        int toIterate = fields.size() + maxMoveBall;

        Field field = fields.get(0);
        int x = field.getXCord();
        int y = field.getYCord();

        Direction direction = move.getDirection();
        int xDir = dService.getDirection(direction, DirectionType.X);
        int yDir = dService.getDirection(direction, DirectionType.Y);

        for (int i = 0; i < toIterate; i++) {
            x += xDir;
            y += yDir;
            Field tempField = bService.findField(x, y, boardSet);
            if (fields.contains(tempField)) {
                continue;
            }
            if (tempField.getBall() != null) {
                ballToMove++;
            } else {
                return true;
            }
            if (ballToMove > maxMoveBall) {
                return false;
            }
        }
        return true;
    }

    public boolean isDirectionLikeRow(Movement move) {
        DirectionService dService = new DirectionService();
        BoardService bService = new BoardService();
        if (move.getFields().size() < MIN_BALLS_TO_SUMITO) {
            return true;
        }
        int xDir = dService.getDirection(move.getDirection(), DirectionType.X);
        int yDir = dService.getDirection(move.getDirection(), DirectionType.Y);
        for (Field field : move.getFields()) {
            if (bService.findField(field.getXCord() + xDir, field.getYCord() + yDir, move.getFields()) == null
                    && bService.findField(field.getXCord() - xDir, field.getYCord() - yDir, move.getFields()) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isMovementEmpty(Movement move) {
        for (Field tempField : move.getFields()) {
            if (tempField.getBall() == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isNeedToMoveBall(Movement move) {
        if (move.getBoard() == null) {
            throw new InternalException(ExceptionMessage.NO_BOARD);
        }
        BoardService bService = new BoardService();
        DirectionService dService = new DirectionService();

        Board board = move.getBoard();
        Direction direction = move.getDirection();

        Field[][] gameBoard = board.getGameBoard();
        Set<Field> boardAsList = bService.boardToFieldList(gameBoard);
        Set<Field> fields = move.getFields();

        int xDir = dService.getDirection(direction, DirectionType.X);
        int yDir = dService.getDirection(direction, DirectionType.Y);
        for (Field field : fields) {
            Field fieldToMove = bService.findField(xDir + field.getXCord(), yDir + field.getYCord(), boardAsList);
            if (!fields.contains(fieldToMove)) {
                if (fieldToMove.getBall() != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
