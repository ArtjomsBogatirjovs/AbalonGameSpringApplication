package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for game result
    Author:Artjoms Bogatirjovs
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Player"
})

public class GameResult {

    @JsonProperty("Player")
    private Player player;

    public GameResult() {}

    /**
     * @param player
     */
    public GameResult(Player player) {
        this.player = player;
    }

    @JsonProperty("Player")
    public Player getPlayer() {
        return player;
    }

    @JsonProperty("Player")
    public void setPlayer(Player player) {
        this.player = player;
    }

}
