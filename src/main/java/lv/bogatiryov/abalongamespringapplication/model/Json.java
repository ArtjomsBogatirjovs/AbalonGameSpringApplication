package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class holder for Gameplay
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Gameplay"
})


public class Json {

    @JsonProperty("Gameplay")
    private Gameplay gameplay;

    public Json() {
    }

    /**
     * @param gameplay
     */
    public Json(Gameplay gameplay) {
        this.gameplay = gameplay;
    }

    @JsonProperty("Gameplay")
    public Gameplay getGameplay() {
        return gameplay;
    }

    @JsonProperty("Gameplay")
    public void setGameplay(Gameplay gameplay) {
        this.gameplay = gameplay;
    }

}
