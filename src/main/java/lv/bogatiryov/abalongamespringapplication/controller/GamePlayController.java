package lv.bogatiryov.abalongamespringapplication.controller;


import javax.servlet.http.HttpSession;

import lv.bogatiryov.abalongamespringapplication.db.domain.Gameplay;
import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import lv.bogatiryov.abalongamespringapplication.dto.GameDTO;
import lv.bogatiryov.abalongamespringapplication.dto.MoveDTO;
import lv.bogatiryov.abalongamespringapplication.exception.InvalidGameException;
import lv.bogatiryov.abalongamespringapplication.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import lv.bogatiryov.abalongamespringapplication.service.GameplayService;
import lv.bogatiryov.abalongamespringapplication.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/game")
public class GamePlayController {

    GameplayService gameplayService;

    PlayerService playerService;

    HttpSession httpSession;

    @PostMapping("/create")
    public ResponseEntity<Gameplay> start(@RequestBody Player player, @RequestBody GameDTO gameDTO) {
        httpSession.setAttribute("gameId", gameDTO.getId());
        log.info("start game request: {}", player);
        return ResponseEntity.ok(gameplayService.createGame(player,gameDTO));
    }

    @PostMapping("/connect")
    public ResponseEntity<Gameplay> connectRandom(@RequestBody GameDTO gameDTO) throws NotFoundException, InvalidGameException {
        //log.info("connect request {}", player);
        return ResponseEntity.ok(gameplayService.connectToGame(playerService.getLoggedUser(),gameDTO));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Gameplay> gamePlay(@RequestBody MoveDTO moveDTO) throws NotFoundException, InvalidGameException {
        Long gameId = (Long) httpSession.getAttribute("gameId");
        Gameplay game = gameplayService.getGameplay(gameId);
        log.info("step request: {}", moveDTO);
        Gameplay gameplay = gameplayService.makeMovement(moveDTO, game);
        return ResponseEntity.ok(gameplay);
    }

}
