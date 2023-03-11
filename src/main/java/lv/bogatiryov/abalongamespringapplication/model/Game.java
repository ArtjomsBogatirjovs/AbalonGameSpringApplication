package lv.bogatiryov.abalongamespringapplication.model;

/*
    Class storage for game steps
    Author:Artjoms Bogatirjovs
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Step"
})


public class Game {

    @JsonProperty("Step")
    private ArrayList<Step> steps = null;

    public Game() {
        super();
    }

    /**
     * @param steps
     */
    public Game(ArrayList<Step> steps) {
        this.steps = steps;
    }

    @JsonProperty("Step")
    public ArrayList<Step> getSteps() {
        return steps;
    }

    @JsonProperty("Step")
    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }


}
