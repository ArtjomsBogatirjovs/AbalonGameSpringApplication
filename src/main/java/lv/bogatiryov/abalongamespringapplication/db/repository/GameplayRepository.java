package lv.bogatiryov.abalongamespringapplication.db.repository;

import lv.bogatiryov.abalongamespringapplication.enums.GameStatus;
import lv.bogatiryov.abalongamespringapplication.enums.GameType;
import lv.bogatiryov.abalongamespringapplication.db.domain.Gameplay;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GameplayRepository extends CrudRepository<Gameplay, Long> {
    List<Gameplay> findByGameTypeAndStatus(GameType GameType, GameStatus status);
    List<Gameplay> findByStatus(GameStatus status);
}