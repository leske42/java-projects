package stage2;

public interface ICrewMember {
    public String getName();
    public String getRole();
    public double getHealth();
    public void reduceHealth(int amount);
    public String getInfo();
}
