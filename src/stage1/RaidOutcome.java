package stage1;

import stage3.RaidType;

public enum RaidOutcome {
        VICTORY(1, "Victory"),
        DEFEAT(2, "Defeat"),
        PEACE(3, "Peace agreement");

        private final int value;
        private final String name;

        RaidOutcome(int value, String name) {
            this.value = value;
            this.name = name;
        }
        public String getDescriptionByValue(int value) {
            for (RaidOutcome type : RaidOutcome.values()) {
                if (type.value == value)
                    return type.name;
            }
            return "unknown";
        }
}
