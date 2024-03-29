package lv.bogatiryov.abalongamespringapplication.service;


import lv.bogatiryov.abalongamespringapplication.db.domain.*;
import lv.bogatiryov.abalongamespringapplication.dto.MoveDTO;
import lv.bogatiryov.abalongamespringapplication.enums.DirectionType;
import lv.bogatiryov.abalongamespringapplication.db.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Set;

@Service
@ComponentScan(basePackages = {"lv.bogatiryov.abalongamespringapplication.repository"})
public class MovementService {

    private final MovementRepository moveRepository;

    @Autowired
    public MovementService(MovementRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public Movement createMove(Gameplay game, Player player, MoveDTO moveDTO) {
        Movement move = new Movement();
        move.setDirection(moveDTO.getDirection());
        move.setFields(moveDTO.getFields());
        move.setCreated(new Date());
        move.setPlayer(player);
        move.setBoard(game.getBoard());

        moveRepository.save(move);

        return move;
    }

    Field getLastFieldInChain(Movement move) {
        DirectionService dService = new DirectionService();
        BoardService bService = new BoardService();

        Direction direction = move.getDirection();
        Set<Field> fields = move.getFields();

        int dirX = dService.getDirection(direction, DirectionType.X) * -1;
        int dirY = dService.getDirection(direction, DirectionType.Y) * -1;

        for (Field field : fields) {
            if (bService.findField(field.getXCord() + dirX, field.getYCord() + dirY, fields) == null) {
                return field;
            }
        }
        return null;
    }
}
