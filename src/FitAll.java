import java.util.ArrayList;
import java.util.Scanner;

public class FitAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Session> sessions = new ArrayList<>();

        // Sample Fitness Sessions (Hardcoded):
        sessions.add(new Session("Chest", "Beginner", "Monday", "14:00", 60, 30));
        sessions.add(new Session("Legs", "Intermediate", "Monday", "17:30", 30, 22));
        sessions.add(new Session("Cycling", "Intermediate", "Monday", "12:45", 90, 10));
        sessions.add(new Session("Yoga", "Advanced", "Monday", "17:00", 45, 50));
        sessions.add(new Session("Zumba", "Beginner", "Monday", "18:00", 30, 40));
        sessions.add(new Session("Pilates", "Advanced", "Monday", "15:00", 60, 20));
        sessions.add(new Session("Back", "Medium", "Monday", "16:00", 90, 25));
        sessions.add(new Session("Core", "Beginner", "Monday", "16:30", 45, 32));

        // Menu
        while (true) {
            System.out.println("\nWelcome to FitAll!");
            System.out.println("1. View our timetable");
            System.out.println("2. Register for one of our sessions");
            System.out.println("3. Cancel Registration");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                for (Session s : sessions) {
                    s.printDetails();
                }
            } else if (choice == 2) {
                System.out.print("Enter Session ID to register: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                boolean found = false;

                for (Session s : sessions) {
                    if (s.getSessionID() == id && s.register()) {
                        System.out.println("You have successfully registered for " + s.getSessionName());
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid Session ID. Please try again.");

                } else {
                    System.out.println("Please enter a numeric Session ID.");
                    scanner.next();
                }

            } else if (choice == 3) {
                System.out.print("Enter your Session ID to cancel: ");
                int id = scanner.nextInt();
                for (Session s : sessions) {
                    if (s.getSessionID() == id && s.cancel()) {
                        System.out.println(
                                "You have successfully cancelled your registeration for " + s.getSessionName());
                        break;
                    }
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!!");
                break;
            } else {
                System.out.println("This option is invalid. Please try again.");
            }
        }
        scanner.close();
    }
}
