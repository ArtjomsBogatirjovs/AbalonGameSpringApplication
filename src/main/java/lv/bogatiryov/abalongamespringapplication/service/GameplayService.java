package lv.bogatiryov.abalongamespringapplication.service;

import lombok.AllArgsConstructor;
import lv.bogatiryov.abalongamespringapplication.exception.ExceptionMessage;
import lv.bogatiryov.abalongamespringapplication.exception.InvalidGameException;
import lv.bogatiryov.abalongamespringapplication.exception.NotFoundException;
import lv.bogatiryov.abalongamespringapplication.model.*;
import lv.bogatiryov.abalongamespringapplication.storages.GameplayStorage;
import lv.bogatiryov.abalongamespringapplication.validator.MovementValidator;
import lv.bogatiryov.abalongamespringapplication.validator.Validatable;
import org.springframework.stereotype.Service;

import java.util.*;

import static lv.bogatiryov.abalongamespringapplication.model.GameStatus.*;

@Service
@AllArgsConstructor
public class GameplayService {

    public Gameplay createGame(Player player) {
        Gameplay gameplay = new Gameplay();
        Game game = new Game();

        BoardService boardService = new BoardService();

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Movement> steps = new ArrayList<>();

        Board gameBoard = boardService.getNewBoard();
        //player.setPlayerID(PlayerId.FIRST.getId());
        players.add(player);

        gameplay.setBoard(gameBoard);
        gameplay.setPlayers(players);
        gameplay.setStatus(NEW);
        gameplay.setGame(game);
        gameplay.getGame().setMovements(steps);

        GameplayStorage.getInstance().setGameplay(gameplay);
        return gameplay;
    }

    public Gameplay connectToGame(Player player) throws NotFoundException, InvalidGameException {

        Gameplay gameplay = getGameplayInstance();

        if (gameplay.getPlayers() == null) {
            throw new NotFoundException(ExceptionMessage.NOT_FOUND.getMessage());
        }

        if (gameplay.getPlayers().size() == 2 && gameplay.getPlayers().get(1) != null) {
            throw new InvalidGameException(ExceptionMessage.IS_FULL.getMessage());
        }

        if (player.getPlayerName().equals(gameplay.getPlayers().get(0).getPlayerName())) {
            // throw new InvalidGameException("Same nickname's not allowd");
        }

        gameplay.getPlayers().add(player);
        //ArrayList<Player> playersOrdered = chooseFirst(gameplay.getPlayers());
        //gameplay.setPlayers(playersOrdered);
        gameplay.setCurrPlayer(player);
        gameplay.setStatus(IN_PROGRESS);
        GameplayStorage.getInstance().setGameplay(gameplay);
        return gameplay;
    }

    private Gameplay getGameplayInstance() {
        return GameplayStorage.getInstance().getGameplay();
    }

    public Gameplay makeMovement(Movement movement) throws NotFoundException, InvalidGameException {
        Validatable<Movement> moveValidator = new MovementValidator();
        BoardService bService = new BoardService();

        Gameplay gameplay = getGameplayInstance();
        Board board = gameplay.getBoard();
        movement.setBoard(board);

        validate(gameplay);
        moveValidator.validate(movement);

        gameplay.getGame().getMovements().add(movement);

        Player currplayer = gameplay.getCurrPlayer();

        gameplay.setBoard(bService.makeMove(board, movement));

/*
        if(checkGameFinish(gameplay.getBoard(), current_player)) {

            if(fullBoardCheck(board)) {
                gameplay.setGameResult(new GameResult());
            } else {
                gameplay.setGameResult(new GameResult(current_player));
            }
            gameplay.setStatus(FINISHED);
        } else {
            gameplay.setCurPlayer(switchPlayer(gameplay.getPlayers(), current_player));
        }
*/
        return gameplay;
    }

    private void validate(Gameplay gameplay) throws NotFoundException, InvalidGameException {
        if (gameplay.getPlayers() == null) {
            throw new NotFoundException(ExceptionMessage.NOT_FOUND.getMessage());
        }

        if (gameplay.getPlayers().size() == 1) {
            throw new InvalidGameException(ExceptionMessage.ONLY_ONE_PLAYER.getMessage());
        }

        if (gameplay.getStatus().equals(FINISHED)) {
            throw new InvalidGameException(ExceptionMessage.FINISHED.getMessage());
        }
    }

    public Gameplay getGameplay(String text) throws NotFoundException, InvalidGameException {

        Gameplay gameplay = getGameplayInstance();

        validate(gameplay);

        //Player current_player = gameplay.getCurPlayer();

        String num = "";
        int steps_size = gameplay.getGame().getMovements().size();

        if (gameplay.getGame().getMovements().size() == 0) {
            num = "1";
        } else {
            // num = Integer.toString(Integer.parseInt(gameplay.getGame().getMovements().get(steps_size - 1).getNum()) + 1);
        }
        //Step step = new Step();
        //step.setNum(num);
        // step.setPlayerId(current_player.getPlayerID());
        //step.setStepValue(text);

        //gameplay.getGame().getMovements().add(step);

        //String[][] board = gameplay.getBoard();

        // String symbol = current_player.getPlayerMark();

        //gameplay.setBoard(placeSymbol1(board, symbol, text, 3));
/*
        if(checkGameFinish(gameplay.getBoard(), current_player)) {

            if(fullBoardCheck(board)) {
                gameplay.setGameResult(new GameResult());
            } else {
            //    gameplay.setGameResult(new GameResult(current_player));
            }
            gameplay.setStatus(FINISHED);
//            gameplay.setCurPlayer(null);
        } else {
           // gameplay.setCurPlayer(switchPlayer(gameplay.getPlayers(), current_player));
        }
*/
        return gameplay;
    }

    public Json getJsonStor(String json_type) throws NotFoundException, InvalidGameException {

        Gameplay gameplayStor = GameplayStorage.getInstance().getGameplay();
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game();
        Player winner = new Player();

        if (gameplayStor.getPlayers() != null) {
            players = gameplayStor.getPlayers();
        }

        if (gameplayStor.getGame() != null) {
            game = gameplayStor.getGame();
        }

        if (gameplayStor.getGameResult() != null) {
            winner = gameplayStor.getGameResult().getPlayer();
        }

        Gameplay gameplay = new Gameplay();
        Json json = new Json(gameplay);

        if (json_type.equals("1")) {
            gameplay.setPlayers(players);
            gameplay.setGame(game);
            gameplay.setGameResult(new GameResult(winner));
            json.setGameplay(gameplay);
        }

        return json;
    }

    private Player switchPlayer(List<Player> players, Player current_player) {

        if (players.get(0).equals(current_player)) {
            return players.get(1);
        }
        return players.get(0);
    }

    private boolean checkGameFinish(String[][] board, Player current_player) {
        return true;
    }


    private boolean winСheck(String[][] matrix, String mark) {
        return false;
    }
    public Board getGameplayBoard(){
        return getGameplayInstance().getBoard();
    }
}
