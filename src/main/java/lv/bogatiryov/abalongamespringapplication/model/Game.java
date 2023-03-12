package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for game movements
    Author:Artjoms Bogatirjovs
 */


import java.util.ArrayList;


public class Game {

    private ArrayList<Movement> movements = null;

    public Game() {
    }

    public Game(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }


}
