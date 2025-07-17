package stage3;

import java.util.Random;
import stage2.CrewManager;

public class Raid {
    private final Random random = new Random();
    RaidResult executeRaid(RaidTarget target, CrewManager crewManager, ShipSystemsManager systemsManager) {
        RaidType type = getRandomRaidType();
        int points = applyTargetModifierToPoints(type.generatePoints(), target);
        int[] health_loss = new int[crewManager.getCrewCount()];
        for (int i = 0; i < health_loss.length; i++) {
            health_loss[i] = generateHealthLoss(type);
        }
        //apply health loss here?
        int[] damage = new int[ShipSystemType.values().length];
        for (int i = 0; i < damage.length; i++) {
            damage[i] = generateSystemDamage(type);
        }
        systemsManager.applyDamageToAll(damage);
        return new RaidResult(type, target, points, damage, health_loss, crewManager.getCrew());
    }

    private RaidType getRandomRaidType() {
        return RaidType.fromValue(random.nextInt(1, 3));
    }

    private int generateHealthLoss(RaidType type) {
        if (type == RaidType.OBSERVATION)
            return random.nextInt(RaidBalance.OBSERVATION_MAX_HEALTH_LOSS + 1);
        else if (type == RaidType.STANDARD)
            return random.nextInt(RaidBalance.STANDARD_MAX_HEALTH_LOSS + 1);
        else
            return random.nextInt(RaidBalance.AGGRESSIVE_MAX_HEALTH_LOSS + 1);
    }

    private int generateSystemDamage(RaidType type) {
        if (type == RaidType.OBSERVATION)
            return random.nextInt(RaidBalance.OBSERVATION_MAX_SYSTEM_DAMAGE + 1);
        else if (type == RaidType.STANDARD)
            return random.nextInt(RaidBalance.STANDARD_MAX_SYSTEM_DAMAGE + 1);
        else
            return random.nextInt(RaidBalance.AGGRESSIVE_MAX_SYSTEM_DAMAGE + 1);
    }

    private int applyTargetModifierToDamage(int baseDamage, RaidTarget target) {
        if (target == RaidTarget.CIVILIAN)
            return (int) (baseDamage * RaidBalance.DAMAGE_MULTIPLIER_CIVILIAN);
        else if (target == RaidTarget.MILITARY)
            return (int) (baseDamage * RaidBalance.DAMAGE_MULTIPLIER_MILITARY);
        else
            return (int) (baseDamage * RaidBalance.DAMAGE_MULTIPLIER_UNKNOWN);
    }

    private int applyTargetModifierToPoints(int basePoints, RaidTarget target) {
        if (target == RaidTarget.CIVILIAN)
            return (int) (basePoints * RaidBalance.POINT_MULTIPLIER_CIVILIAN);
        else if (target == RaidTarget.MILITARY)
            return (int) (basePoints * RaidBalance.POINT_MULTIPLIER_MILITARY);
        else
            return (int) (basePoints * RaidBalance.POINT_MULTIPLIER_UNKNOWN);
    }
}
