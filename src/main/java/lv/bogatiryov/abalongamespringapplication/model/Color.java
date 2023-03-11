package lv.bogatiryov.abalongamespringapplication.model;

public enum Color {
    WHITE("white"),
    BLACK("black");
    private final String name;
    Color(String aName) {
        name = aName;
    }
    public String getName() {
        return name;
    }
}
