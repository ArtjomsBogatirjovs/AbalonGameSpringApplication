package lv.bogatiryov.abalongamespringapplication.security;

import com.google.common.collect.ImmutableSet;
import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class ContextUser extends org.springframework.security.core.userdetails.User {

    private final Player player;

    public ContextUser(Player player) {
        super(player.getName(),
                player.getPassword(),
                true,
                true,
                true,
                true,
                ImmutableSet.of(new SimpleGrantedAuthority("create")));

        this.player = player;
    }

    public Player getPlayer() {
        return  player;
    }
}
