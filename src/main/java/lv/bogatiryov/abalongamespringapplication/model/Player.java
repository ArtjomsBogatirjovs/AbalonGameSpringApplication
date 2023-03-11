package lv.bogatiryov.abalongamespringapplication.model;

/*
    Abalone player
    Author:Artjoms Bogatirjovs
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "color"
})

public class Player {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("color")
    private Color color;

    private Movement movement;

    public Player() {
    }

    /**
     * @param id
     * @param name
     * @param color
     */
    public Player(String id, String name, Color color) {
        this.name = name;
        this.color = color;
        this.id = id;
    }

    @JsonProperty("id")
    public String getPlayerID() {
        return id;
    }

    @JsonProperty("id")
    public void setPlayerID(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getPlayerName() {
        return name;
    }

    @JsonProperty("name")
    public void setPlayerName(String name) {
        this.name = name;
    }

    @JsonProperty("color")
    public Color getPlayerColor() {
        return color;
    }

    @JsonProperty("color")
    public void setPlayerColor(Color color) {
        this.color = color;
    }

}
