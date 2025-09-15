package stage2;

public class CombatPirate extends CrewMember {
    public CombatPirate(String name, double health) {
        super(name, health);
    }

    public String getRole() {
        return "Combat Pirate";
    }
}
