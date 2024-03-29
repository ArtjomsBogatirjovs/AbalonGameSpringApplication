package lv.bogatiryov.abalongamespringapplication.service;

import lv.bogatiryov.abalongamespringapplication.dto.PlayerDTO;
import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import lv.bogatiryov.abalongamespringapplication.db.repository.PlayerRepository;
import lv.bogatiryov.abalongamespringapplication.security.ContextUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createNewPlayer(PlayerDTO playerDTO) {
        Player newPlayer = new Player();
        newPlayer.setName(playerDTO.getUserName());
        newPlayer.setPassword(passwordEncoder.encode(playerDTO.getPassword()));
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    public Player getLoggedUser() {
        ContextUser principal = (ContextUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return playerRepository.findOneByName(principal.getPlayer().getName());
    }
    public List<Player> listPlayers() {
        return (List<Player>) playerRepository.findAll();
    }
}
