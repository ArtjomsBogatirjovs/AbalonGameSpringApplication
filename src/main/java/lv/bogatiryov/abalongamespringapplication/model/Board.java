package lv.bogatiryov.abalongamespringapplication.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
public class Board {
    private Field[][] gameBoard;
    private ArrayList<Field> fieldList; //TODO change to set

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

    public ArrayList<Field> getFieldList() {
        return new ArrayList<>(List.copyOf(fieldList));
    }

    public void setFieldList(ArrayList<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
