package stage2;

import java.lang.reflect.Array;

public class CrewManager {
    private ICrewMember[] crew = new ICrewMember[10];
    private int crewSize = 0;

    public CrewManager() {
        addCrewMember(new Captain("Morgan", 100));
        addCrewMember(new CombatPirate("Bob Wanderer", 100));
        addCrewMember(new CombatPirate("Jane Sword", 100));
    }

    public void addCrewMember(ICrewMember member) {
        if (crewSize < crew.length) {
            crew[crewSize] = member;
            crewSize++;
        } else {
            System.out.println("Crew is full");
        }
    }

    public void viewCrew(int points) {
        System.out.println("\n[Crew Information]");
        if (crewSize == 0)
            System.out.println("Crew is empty"); //tho this will likely never happen
        for (int i = 0; i < crewSize; i++) {
            System.out.println(crew[i].getInfo());
        }
        System.out.println("Total points: " + points);
    }

    public ICrewMember[] getCrew() {
        ICrewMember[] crewCopy = new ICrewMember[crewSize];
        int j = 0;
        for (ICrewMember member : crew) {
            if (member != null)
                crewCopy[j++] = member;
        }
        return crewCopy;
    }

    int getCrewCount() {
        return crewSize;
    }
}
