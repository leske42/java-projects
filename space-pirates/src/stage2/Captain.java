package stage2;

public class Captain extends CrewMember {

    public Captain(String name, double health) {
        super(name, health);
    }

    public String getRole() {
        return "Captain";
    }
}
