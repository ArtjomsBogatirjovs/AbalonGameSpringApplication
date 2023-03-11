package lv.bogatiryov.abalongamespringapplication.model;

public enum PlayerId {
    FIRST("1"),
    SECOND("2");
    private final String id;
    PlayerId(String anId) {
        id = anId;
    }
    public String getId() {
        return id;
    }
}
