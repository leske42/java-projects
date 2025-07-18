package stage1;

import com.sun.jdi.connect.Connector;
import stage2.Captain;
import stage2.CombatPirate;
import stage2.CrewManager;
import stage2.ICrewMember;
import stage3.Raid;
import stage3.RaidResult;
import stage3.RaidTarget;
import stage3.ShipSystemsManager;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int CAPTAIN_COST = 200;
    private static final int COMBAT_PIRATE_COST = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CrewManager crewManager = new CrewManager();
        ShipSystemsManager systemsManager = new ShipSystemsManager();
        System.out.println("Welcome, Captain! Prepare for adventure in the galaxy.");
        int totalPoints = 1000;
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1 - View Crew\n2 - Launch a raid");
            System.out.println("3 - Repair System\n4 - Add crew member");
            System.out.println("5 - Statistics\n6 - Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    crewManager.viewCrew(totalPoints);
                    break;
                case 2:
                    totalPoints += launchRaid(sc, crewManager, systemsManager, totalPoints);
                    break;
                case 3:
                    repairSystems();
                    break;
                case 4:
                    totalPoints -= addCrewMember(sc, totalPoints, crewManager);
                    break;
                case 5:
                    statistics();
                    break;
                case 6:
                    System.out.println("\nGoodbye, Captain! See you next time.");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static int generateRaidOutcome() {
        Random random = new Random();
        return random.nextInt(1, 4); //bound is exclusive
    }

    private static int launchRaid(Scanner sc, CrewManager crew, ShipSystemsManager systems, int points) {
        System.out.println("\nSelect Raid Target:");
        System.out.println("1. Civilian Ship\n2. Military Ship\n3. Unknown Vessel");
        System.out.print("Your choice: ");
        int value = sc.nextInt();
        RaidTarget target = RaidTarget.fromValue(value);
        System.out.print("Launching observation raid on ");
        switch (target) {
            case CIVILIAN:
                System.out.println("Civilian Ship...");
                break;
            case MILITARY:
                 System.out.println("Military Ship...");
                 break;
            case UNKNOWN:
                 System.out.println("Unknown Vessel...");
                 break;
             default:
                 System.out.println("Invalid choice");
                 return 0;
        }
        Raid raid = new Raid();
        RaidResult result = raid.executeRaid(target, crew, systems);
        System.out.println("Raid outcome: " + RaidOutcome.VICTORY.getDescriptionByValue(generateRaidOutcome()));
        printResult(result, crew, systems, points);
        return result.getPointsEarned();
    }

    private static void printResult(RaidResult result, CrewManager crew, ShipSystemsManager systems, int points) {
        System.out.println("\n[RAID RESULTS]\nPoints earned: " + result.getPointsEarned());
        System.out.println("Raid type was: " + result.getRaidType() + "\nShip attacked was: " + result.getTargetType());
        crew.viewCrew(points + result.getPointsEarned());
        System.out.println("System status: " + systems.getStatus());
    }

    private static void repairSystems() {
        System.out.println("\n[Repair Systems]");
        System.out.println("Systems are 100% healthy");
    }

    private static int addCrewMember(Scanner sc, int points, CrewManager crew) {
        sc.nextLine(); //discard newline from number choice here
        System.out.println("\n[Add Crew Member]");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter role: ");
        String role = sc.nextLine().toLowerCase();
        if (!role.equals("captain") && !role.equals("combat pirate")) {
            System.out.println("Invalid role. Crew member not added.");
            return 0;
        }
        int deduct = 0;
        ICrewMember member;
        if (role.equals("captain")) {
            if (points < CAPTAIN_COST) {
                System.out.println("Not enough points to add a Captain");
                return 0;
            }
            member = new Captain(name, 100);
            deduct = CAPTAIN_COST;
        }
        else {
            if (points < COMBAT_PIRATE_COST) {
                System.out.println("Not enough points to add a Combat Pirate");
                return 0;
            }
            member = new CombatPirate(name, 100);
            deduct = COMBAT_PIRATE_COST;

        }
        crew.addCrewMember(member);
        System.out.println("New crew member added: " + member.getInfo());
        System.out.println("Points deducted: " + deduct);
        return deduct;
    }

    private static void statistics() {
        System.out.println("\n[Raid Statistics]");
        System.out.println("No statistics available");
    }
}

