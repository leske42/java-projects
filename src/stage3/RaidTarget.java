package stage3;

public enum RaidTarget {
    CIVILIAN (1, "Civilian ship"),
    MILITARY (1, "Military ship"),
    UNKNOWN (3, "Unknown vessel");

    private final int value;
    private final String name;

    RaidTarget(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static RaidTarget fromValue(int value) {
        for (RaidTarget type : RaidTarget.values()) {
            if (type.value == value)
                return type;
        }
        return null;
    }
}
