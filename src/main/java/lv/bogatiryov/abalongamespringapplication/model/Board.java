package lv.bogatiryov.abalongamespringapplication.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@EqualsAndHashCode
@AllArgsConstructor
@Component
public class Board {
    private Field[][] gameBoard;
    private ArrayList<Field> fieldList;

    public Board() {
    }

    public Board(Field[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Board(ArrayList<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Field[][] getGameBoard() {
        return gameBoard.clone();
    }

    public void setGameBoard(Field[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
