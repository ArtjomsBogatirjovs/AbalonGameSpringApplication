package lv.bogatiryov.abalongamespringapplication.db.repository;

import lv.bogatiryov.abalongamespringapplication.db.domain.Board;
import lv.bogatiryov.abalongamespringapplication.db.domain.Movement;
import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {

    List<Movement> findByBoard(Board board);
    List<Movement> findByBoardAndPlayer(Board board, Player player);
    int countByBoardAndPlayer(Board game, Player player);
}
