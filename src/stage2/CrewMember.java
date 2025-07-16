package stage2;

public abstract class CrewMember implements ICrewMember {
    private String name;
    private double health;

    public CrewMember(String name, double health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public String getInfo() {
        return (getRole() + ": " + getName() + " (Life: " + getHealth() + "%)");
    }
}
