package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for gameplay
    Author:Artjoms Bogatirjovs
 */

import java.util.ArrayList;


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

    public Player getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

}
