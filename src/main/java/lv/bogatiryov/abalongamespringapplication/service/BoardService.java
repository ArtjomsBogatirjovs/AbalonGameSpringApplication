package lv.bogatiryov.abalongamespringapplication.service;

import lv.bogatiryov.abalongamespringapplication.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BoardService {
    private final static Ball W = new Ball(Color.WHITE);
    private final static Ball B = new Ball(Color.BLACK);
    private final static int BOARD_SIZE = 11;
    private final static int GAMING_BOARD_MIDDLE = BOARD_SIZE / 2;
    private final static int DROP_FIELD = 0;

    public Board getNewBoard() {
        Field[][] tempBoard = createBoard();
        return new Board(tempBoard);
    }

    public Field[][] createBoard() {

        Field[][] gameBoard = new Field[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x <= GAMING_BOARD_MIDDLE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (DROP_FIELD == y || y - x >= GAMING_BOARD_MIDDLE || DROP_FIELD == x) {
                    int opX = calculateOppositeCord(x);
                    int opY = calculateOppositeCord(y);
                    gameBoard[y][x] = new DropField(x, y);
                    gameBoard[opY][opX] = new DropField(opX, opY);
                } else if (x < 3 || (x == 3 && y < 6 && y > 2)) {
                    gameBoard[y][x] = new Field(B, x, y);
                    int opX = calculateOppositeCord(x);
                    int opY = calculateOppositeCord(y);
                    gameBoard[opY][opX] = new Field(W, opX, opY);
                } else {
                    gameBoard[y][x] = new Field(x, y);
                    int opX = calculateOppositeCord(x);
                    int opY = calculateOppositeCord(y);
                    gameBoard[opY][opX] = new Field(opX, opY);
                }
            }
        }
        return gameBoard;
    }

    public ArrayList<Field> boardToFieldList(Field[][] board) {
        ArrayList<Field> result = new ArrayList<>();
        for (Field[] fieldArray : board) {
            result.addAll(Arrays.asList(fieldArray));
        }
        return result;
    }

    public boolean makeMove(Board board, Movement move) {
        ArrayList<Field> fieldsToMove = move.getFields();
        Direction direction = move.getDirection();

        int xDirection = direction.isX() ? Directions.TRUE.getDirection() : Directions.FALSE.getDirection();
        int yDirection = direction.isY() ? Directions.TRUE.getDirection() : Directions.FALSE.getDirection();

        ArrayList<Field> tempBoard = boardToFieldList(board.getGameBoard());
        for (Field field : fieldsToMove) {
            Field tempField = findField(field, tempBoard);
            Field fieldToMove = findField(tempField.getXCord() + xDirection, tempField.getYCord() + yDirection, tempBoard);
            transferBall(tempField,fieldToMove);
        }
        return true;
    }

    public Field findField(int x, int y, ArrayList<Field> board) {
        return findField(null, x, y, board);
    }

    public Field findField(Field fieldToFind, ArrayList<Field> board) {
        return findField(fieldToFind, null, null, board);
    }

    public Field findField(Field fieldToFind, Integer x, Integer y, ArrayList<Field> board) {
        if (board.contains(fieldToFind)) {
            int index = board.indexOf(fieldToFind);
            return board.get(index);
        }

        if (fieldToFind != null) {
            return board.stream()
                    .filter(field -> field.getXCord() == fieldToFind.getXCord())
                    .filter(field -> field.getYCord() == fieldToFind.getYCord())
                    .filter(field -> field.getBall().equals(fieldToFind.getBall()))
                    .findAny()
                    .orElse(null);
        }

        if (x != null && y != null) {
            return board.stream()
                    .filter(field -> field.getXCord() == x)
                    .filter(field -> field.getYCord() == y)
                    .findAny()
                    .orElse(null);
        }

        return null;
    }

    private int calculateOppositeCord(int cord) {
        return (BOARD_SIZE - 1) - cord;
    }
    private boolean transferBall(Field field, Field fieldToMove){
        fieldToMove.setBall(field.getBall());
        field.setBall(null);
        return true;
    }
}
