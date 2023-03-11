package lv.bogatiryov.abalongamespringapplication.controller;

import lv.bogatiryov.abalongamespringapplication.exception.InvalidGameException;
import lv.bogatiryov.abalongamespringapplication.exception.NotFoundException;
import lv.bogatiryov.abalongamespringapplication.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.bogatiryov.abalongamespringapplication.service.GameplayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/gameplay")
public class GamePlayController {
    GameplayService gameplayService;

    @PostMapping("/start")
    public ResponseEntity<Gameplay> start(@RequestBody Player player) {
        log.info("start game request: {}", player);
        return ResponseEntity.ok(gameplayService.createGame(player));
    }

    @PostMapping("/connect")
    public ResponseEntity<Gameplay> connectRandom(@RequestBody Player player) throws NotFoundException, InvalidGameException {
        log.info("connect request {}", player);
        return ResponseEntity.ok(gameplayService.connectToGame(player));
    }

    @PostMapping("/game")
    public ResponseEntity<Gameplay> gamePlay(@RequestBody Movement request) throws NotFoundException, InvalidGameException {
        log.info("step request: {}", request);
        Gameplay gameplay = gameplayService.makeMovement(request);
        return ResponseEntity.ok(gameplay);
    }

    @GetMapping("/game")
    public ResponseEntity<Gameplay> gamePlay_(@RequestParam("text") String text) throws NotFoundException, InvalidGameException {
        log.info("step text request: {}", text);
        Gameplay gameplay = gameplayService.getGameplay(text);
        return ResponseEntity.ok(gameplay);
    }

    @GetMapping("/playback")
    public ResponseEntity<Json> gamePlay1(@RequestParam("json") String json_type) throws NotFoundException, InvalidGameException {
        log.info("json request: {}", json_type);
        Json json = gameplayService.getJsonStor(json_type);
        return ResponseEntity.ok(json);
    }


}
