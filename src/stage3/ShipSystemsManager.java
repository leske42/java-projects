package stage3;

import java.util.Arrays;

public class ShipSystemsManager {
    //so does final only apply to array size and not elements?
    private final int[] systemHealth = new int[ShipSystemType.values().length];

    ShipSystemsManager() {
        for (ShipSystemType type : ShipSystemType.values()) {
            systemHealth[type.ordinal()] = 100;
        }
    }

    void applyDamage(ShipSystemType type, int percent) {
        systemHealth[type.ordinal()] -= percent;
        if (systemHealth[type.ordinal()] < 0)
            systemHealth[type.ordinal()] = 0;
    }

    void applyDamageToAll(int[] damageBySystem) {
        for (int i = 0; i < systemHealth.length; i++) {
            systemHealth[i] -= damageBySystem[i];
            if (systemHealth[i] < 0)
                systemHealth[i] = 0;
        }
    }

    String getStatus() {
        return "Weapons: " + systemHealth[0] + "%\nNavigation: " + systemHealth[1] + "%\nLife Support: " + systemHealth[2] + "%";
    }
}
