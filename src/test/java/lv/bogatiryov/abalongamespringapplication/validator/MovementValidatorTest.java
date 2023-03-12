package lv.bogatiryov.abalongamespringapplication.validator;

import lv.bogatiryov.abalongamespringapplication.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovementValidatorTest { //TODO add tests

    private MovementValidator validator;
    @BeforeEach
    void setUp() {
        validator = new MovementValidator();
    }

    @Test
    void isNeedToMoveBall() {
        Direction dir = new Direction(false,null);
        ArrayList<Field>  fields = new ArrayList<>();
        fields.add(new Field(1,-1));
        fields.add(new Field(0,-2));
        fields.add(new Field(2,0));
        Movement move = new Movement(dir,fields,"test");
        Board board = new Board();
        Field [][] testBoard = {
                {new Field(-1,1),new Field(0,1),new Field(1,1),new Field(2,1),new Field(3,1)},
                {new Field(-1,0),new Field(0,0),new Field(new Ball(Color.WHITE),1,0),new Field(2,0),new Field(3,0)},
                {new Field(-1,-1),new Field(0,-1),new Field(1,-1),new Field(2,-1),new Field(3,-1)},
                {new Field(-1,-2),new Field(0,-2),new Field(1,-2),new Field(2,-2),new Field(3,-2)},
                {new Field(-1,-3),new Field(0,-3),new Field(1,-3),new Field(2,-3),new Field(3,-3)},
        };
        board.setGameBoard(testBoard);
        move.setBoard(board);
        assertTrue(validator.isNeedToMoveBall(move));
    }
    @Test
    void isNotNeedToMoveBall() {
        Direction dir = new Direction(true,null);
        ArrayList<Field>  fields = new ArrayList<>();
        fields.add(new Field(1,-1));
        fields.add(new Field(0,-2));
        fields.add(new Field(2,0));
        Movement move = new Movement(dir,fields,"test");
        Board board = new Board();
        Field [][] testBoard = {
                {new Field(-1,1),new Field(0,1),new Field(1,1),new Field(2,1),new Field(3,1)},
                {new Field(-1,0),new Field(0,0),new Field(new Ball(Color.WHITE),1,0),new Field(2,0),new Field(3,0)},
                {new Field(-1,-1),new Field(0,-1),new Field(new Ball(Color.BLACK),1,-1),new Field(2,-1),new Field(3,-1)},
                {new Field(-1,-2),new Field(0,-2),new Field(1,-2),new Field(2,-2),new Field(new Ball(Color.BLACK),3,-2)},
                {new Field(-1,-3),new Field(0,-3),new Field(1,-3),new Field(2,-3),new Field(3,-3)},
        };
        board.setGameBoard(testBoard);
        move.setBoard(board);
        assertFalse(validator.isNeedToMoveBall(move));
    }

    @Test
    void testIsDirectionNotLikeRow() {
        Direction dir = new Direction(null,true);
        ArrayList<Field>  fields = new ArrayList<>();
        fields.add(new Field(0,0));
        fields.add(new Field(1,1));
        fields.add(new Field(-1,-1));
        Movement move = new Movement(dir,fields,"test");
        assertFalse(validator.isDirectionLikeRow(move));
    }
    @Test
    void testIsDirectionLikeRow() {
        Direction dir = new Direction(false,false);
        ArrayList<Field>  fields = new ArrayList<>();
        fields.add(new Field(0,0));
        fields.add(new Field(1,1));
        fields.add(new Field(-1,-1));
        Movement move = new Movement(dir,fields,"test");
        assertTrue(validator.isDirectionLikeRow(move));
    }
}