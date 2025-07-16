package stage1;

import stage2.CrewManager;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CrewManager crewManager = new CrewManager();
        System.out.println("Welcome, Captain! Prepare for adventure in the galaxy.");
        int totalPoints = 0;
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
                    launchRaid(sc);
                    break;
                case 3:
                    repairSystems();
                    break;
                case 4:
                    addCrewMember();
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

    private enum RaidOutcome {
        VICTORY,
        DEFEAT,
        PEACE;
        public String getDescriptionByValue(int value) {
            return switch (value) {
                case 1 -> "Victory";
                case 2 -> "Defeat";
                case 3 -> "Peace agreement";
                default -> "Unknown";
            };
        }
    }

    private static void viewCrew() {
        System.out.println("\n[Crew Information]");
        System.out.println("Crew is currently empty");
    }

    private static void launchRaid(Scanner sc) {
        System.out.println("\nSelect Raid Target:");
        System.out.println("1. Civilian Ship\n2. Military Ship\n3. Unknown Vessel");
        System.out.print("Your choice: ");
        int target = sc.nextInt();
        System.out.print("Launching observation raid on ");
        switch (target) {
            case 1:
                System.out.println("Civilian Ship...");
                break;
             case 2:
                 System.out.println("Military Ship...");
                 break;
             case 3:
                 System.out.println("Unknown Vessel...");
                 break;
             default:
                 System.out.println("Invalid choice");
        }
        System.out.println("Raid outcome: " + RaidOutcome.VICTORY.getDescriptionByValue(generateRaidOutcome()));
    }

    private static void repairSystems() {
        System.out.println("\n[Repair Systems]");
        System.out.println("Systems are 100% healthy");
    }

    private static void addCrewMember() {
        System.out.println("\n[Add Crew Member]");
        System.out.println("Not enough money");
    }

    private static void statistics() {
        System.out.println("\n[Raid Statistics]");
        System.out.println("No statistics available");
    }
}

