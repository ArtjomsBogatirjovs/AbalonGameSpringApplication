package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for gameplay
    Author:Artjoms Bogatirjovs
 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Gameplay {

    private Board board;
    private ArrayList<Player> players = null;
    private Game game;
    private GameResult gameResult;
    private GameStatus status;
    private Player currPlayer;


    public Gameplay() {
    }

    public Gameplay(ArrayList<Player> players, Board board,
                    Game game, GameResult gameResult, GameStatus status) {
        super();
        this.board = board;
        this.players = players;
        this.game = game;
        this.gameResult = gameResult;
        this.status = status;
    }
}
