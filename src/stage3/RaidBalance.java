package stage3;

public class RaidBalance {
    /** Maximum health loss (percent) during an observation raid. */
    public static final int OBSERVATION_MAX_HEALTH_LOSS = 10;
    /** Maximum health loss (percent) during a standard raid. */
    public static final int STANDARD_MAX_HEALTH_LOSS = 30;
    /** Maximum health loss (percent) during an aggressive raid. */
    public static final int AGGRESSIVE_MAX_HEALTH_LOSS = 60;

    /** Maximum system damage (percent) during an observation raid. */
    public static final int OBSERVATION_MAX_SYSTEM_DAMAGE = 5;
    /** Maximum system damage (percent) during a standard raid. */
    public static final int STANDARD_MAX_SYSTEM_DAMAGE = 15;
    /** Maximum system damage (percent) during an aggressive raid. */
    public static final int AGGRESSIVE_MAX_SYSTEM_DAMAGE = 30;

    /** Minimum points for an observation raid. */
    public static final int OBSERVATION_MIN_POINTS = 0;
    /** Maximum points for an observation raid. */
    public static final int OBSERVATION_MAX_POINTS = 300;

    /** Minimum points for a standard raid. */
    public static final int STANDARD_MIN_POINTS = 100;
    /** Maximum points for a standard raid. */
    public static final int STANDARD_MAX_POINTS = 600;

    /** Minimum points for an aggressive raid. */
    public static final int AGGRESSIVE_MIN_POINTS = 300;
    /** Maximum points for an aggressive raid. */
    public static final int AGGRESSIVE_MAX_POINTS = 1000;

    /** Multiplier for damage when attacking a civilian ship. */
    public static final double DAMAGE_MULTIPLIER_CIVILIAN = 0.5;
    /** Multiplier for damage when attacking a military ship. */
    public static final double DAMAGE_MULTIPLIER_MILITARY = 1.2;
    /** Multiplier for damage when attacking an unknown vessel. */
    public static final double DAMAGE_MULTIPLIER_UNKNOWN = 1.0;

    /** Multiplier for points when attacking a civilian ship. */
    public static final double POINT_MULTIPLIER_CIVILIAN = 0.8;
    /** Multiplier for points when attacking a military ship. */
    public static final double POINT_MULTIPLIER_MILITARY = 1.3;
    /** Multiplier for points when attacking an unknown vessel. */
    public static final double POINT_MULTIPLIER_UNKNOWN = 1.0;
}
