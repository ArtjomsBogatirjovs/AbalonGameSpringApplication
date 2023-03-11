package lv.bogatiryov.abalongamespringapplication.model;

public class Board {
    private final static Ball W = new Ball(Color.WHITE);
    private final static Ball B = new Ball(Color.BLACK);
    private Field[][] gameBoard;
    /*
    private Field[][] gameBoard = {

            {new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),}, //0
                 //null            //A         //B         //C         //D          //E        //F         //G         //H         //I          /null
            {new DropField(),new Field(B),new Field(B),new Field(),new Field(),new Field(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField()}, //1
            {new DropField(),new Field(B),new Field(B),new Field(),new Field(),new Field(),new Field(),new DropField(),new DropField(),new DropField(),new DropField()}, //2
            {new DropField(),new Field(B),new Field(B),new Field(B),new Field(),new Field(),new Field(),new Field(),new DropField(),new DropField(),new DropField()}, //3
            {new DropField(),new Field(B),new Field(B),new Field(B),new Field(),new Field(),new Field(),new Field(),new Field(W),new DropField(),new DropField()}, //4
            {new DropField(),new Field(B),new Field(B),new Field(B),new Field(),new Field(),new Field(),new Field(W),new Field(W),new Field(W),new DropField()}, //5
            {new DropField(),new Field(),new Field(B),new Field(),new DropField(),new Field(),new Field(),new Field(W),new Field(W),new Field(W),new DropField()}, //6
            {new DropField(),new Field(),new Field(),new DropField(),new DropField(),new Field(),new Field(),new Field(W),new Field(W),new Field(W),new DropField()}, //7
            {new DropField(),new Field(),new DropField(),new DropField(),new DropField(),new Field(),new Field(),new Field(),new Field(W),new Field(W),new DropField()}, //8
            {new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new Field(),new Field(),new Field(),new Field(W),new Field(W),new DropField()}, //9
            {new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField(),new DropField()}, //10

    };
     */
    public Board() {
    }

    public Field[][] getGameBoard() {
        return gameBoard.clone();
    }

    public void setGameBoard(Field[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
