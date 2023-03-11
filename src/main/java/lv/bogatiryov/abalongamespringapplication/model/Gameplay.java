package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for gameplay
    Author:Artjoms Bogatirjovs
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Player",
    "Game",
    "GameResult"
})


public class Gameplay {

    private Board board;
    @JsonProperty("Player")
    private ArrayList<Player> players = null;
    @JsonProperty("Game")
    private Game game;
    @JsonProperty("GameResult")
    private GameResult gameResult;
    private GameStatus status;
    private Player currPlayer;


    public Gameplay() {
    }

    /**
     * @param players
     * @param game
     * @param gameResult
     */
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

    @JsonProperty("Player")
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @JsonProperty("Player")
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @JsonProperty("Game")
    public Game getGame() {
        return game;
    }

    @JsonProperty("Game")
    public void setGame(Game game) {
        this.game = game;
    }

    @JsonProperty("GameResult")
    public GameResult getGameResult() {
        return gameResult;
    }

    @JsonProperty("GameResult")
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

}
