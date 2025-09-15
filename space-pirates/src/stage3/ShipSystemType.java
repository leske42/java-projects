package stage3;

public enum ShipSystemType {
    WEAPONS("Weapons system"),
    NAVIGATION("Navigation system"),
    LIFE_SUPPORT("Life support system");

    private final String name;

    ShipSystemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
