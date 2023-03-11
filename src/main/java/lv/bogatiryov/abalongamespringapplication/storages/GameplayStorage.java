package lv.bogatiryov.abalongamespringapplication.storages;

import lv.bogatiryov.abalongamespringapplication.model.Gameplay;

public class GameplayStorage {

    private static Gameplay gameplay = null;
    private static GameplayStorage instance = null;

    private GameplayStorage() {
        gameplay = new Gameplay();
    }

    public static synchronized GameplayStorage getInstance() {
        if (instance == null) {
            instance = new GameplayStorage();
        }
        return instance;
    }

    public Gameplay getGameplay() {
        return gameplay;
    }

    public void setGameplay(Gameplay gameplay) {
        this.gameplay = gameplay;
    }
}
