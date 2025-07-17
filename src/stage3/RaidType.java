package stage3;
import java.util.Random;

public enum RaidType {
    OBSERVATION(1, "Observation raid"),
    STANDARD(2, "Standard raid"),
    AGGRESSIVE(3, "Aggressive raid");

    private final int value;
    private final String displayName;

    private static final Random random = new Random();

    RaidType(int value, String name) {
        this.value = value;
        this.displayName = name;
    }

    public int generatePoints() {
        if (this == OBSERVATION)
            return random.nextInt(RaidBalance.OBSERVATION_MIN_POINTS, RaidBalance.OBSERVATION_MAX_POINTS + 1);
        else if (this == STANDARD)
            return random.nextInt(RaidBalance.STANDARD_MIN_POINTS, RaidBalance.STANDARD_MAX_POINTS + 1);
        else
            return random.nextInt(RaidBalance.AGGRESSIVE_MIN_POINTS, RaidBalance.AGGRESSIVE_MAX_POINTS + 1);
    }

    public static RaidType fromValue(int value) {
        for (RaidType type : RaidType.values()) {
            if (type.value == value)
                return type;
        }
        return null;
    }

    public String getName() {
        return displayName;
    }

    }

