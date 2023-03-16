package lv.bogatiryov.abalongamespringapplication.db.repository;

import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findOneByName(String name);
}
