package stage3;

import stage1.RaidOutcome;
import stage2.ICrewMember;

public class RaidResult {
    private final RaidType raidType;
    private final RaidTarget targetType;
    private final int pointsEarned;
    private final int[] systemDamage;
    private final int[] crewHealthLoss;
    private final ICrewMember[] crewMembers;

    RaidResult(RaidType raidType, RaidTarget targetType, int pointsEarned, int[] systemDamage, int[] crewHealthLoss, ICrewMember[] crewMembers) {
        this.raidType = raidType;
        this.targetType = targetType;
        this.pointsEarned = pointsEarned;
        this.systemDamage = systemDamage;
        this.crewHealthLoss = crewHealthLoss;
        this.crewMembers = crewMembers;
    }

    public RaidType getRaidType() {
        return raidType;
    }

    public RaidTarget getTargetType() {
        return targetType;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public int[] getSystemDamage() {
        return systemDamage;
    }

    public int[] getCrewHealthLoss() {
        return crewHealthLoss;
    }

    public ICrewMember[] getCrewMembers() {
        return crewMembers;
    }
}
