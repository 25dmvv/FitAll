import java.util.ArrayList;
import java.util.Scanner;

public class FitAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Session> sessions = new ArrayList<>(); // Tracks all sessions
        ArrayList<Integer> registeredSessions = new ArrayList<>(); // Tracks registered sessions

        // Sample Fitness Sessions (Hardcoded)
        sessions.add(new Session("Chest", "Beginner", "Monday", "14:00", 60, 30));
        sessions.add(new Session("Legs", "Intermediate", "Monday", "17:30", 30, 22));
        sessions.add(new Session("Cycling", "Intermediate", "Monday", "12:45", 90, 10));
        sessions.add(new Session("Yoga", "Advanced", "Monday", "17:00", 45, 50));
        sessions.add(new Session("Zumba", "Beginner", "Monday", "18:00", 30, 40));
        sessions.add(new Session("Pilates", "Advanced", "Monday", "15:00", 60, 20));
        sessions.add(new Session("Back", "Medium", "Monday", "16:00", 90, 25));
        sessions.add(new Session("Core", "Beginner", "Monday", "16:30", 45, 32));

        int choice;

        // Menu
        while (true) {
            System.out.println("\nWelcome to FitAll!");
            System.out.println("1. View our timetable");
            System.out.println("2. Register for a session");
            System.out.println("3. Cancel Registration");
            System.out.println("4. View your registered sessions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            if (choice == 1) { // View full timetable
                for (Session s : sessions) {
                    s.printDetails();
                }
            } else if (choice == 2) { // Register for a session
                System.out.print("Enter Session ID to register: ");
                if (scanner.hasNextInt()) {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Session s : sessions) {
                        if (s.getSessionID() == id) {
                            if (s.register()) {
                                registeredSessions.add(id);
                                System.out.println("You have successfully registered for " + s.getSessionName());
                            } else {
                                System.out.println("No spaces left.");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid Session ID.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric Session ID.");
                    scanner.next();
                }
            } else if (choice == 3) { // Cancel a registration
                System.out.print("Enter your Session ID to cancel: ");
                if (scanner.hasNextInt()) {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Session s : sessions) {
                        if (s.getSessionID() == id) {
                            if (s.cancel()) {
                                registeredSessions.remove(Integer.valueOf(id));
                                System.out.println("You have cancelled your registration for " + s.getSessionName());
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Session ID.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric Session ID.");
                    scanner.next();
                }
            } else if (choice == 4) { // View registered sessions
                System.out.println("\nYour Registered Sessions:");
                if (registeredSessions.isEmpty()) {
                    System.out.println("You have not registered for any sessions yet.");
                } else {
                    for (Session s : sessions) {
                        if (registeredSessions.contains(s.getSessionID())) {
                            s.printDetails();
                        }
                    }
                }
            } else if (choice == 5) { // Exit
                System.out.println("Goodbye!!");
                break;
            } else {
                System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }
}
