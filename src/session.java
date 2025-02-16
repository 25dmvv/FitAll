
public class Session {
    // Private Properties
    private static int sessionCounter = 1;
    private int sessionID;
    private String sessionName;
    private String levelOfFitness;
    private String day;
    private String startTime;
    private int duration;
    private int availableSpaces;

    // Constructor Method
    public Session(String sessionName, String levelOfFitness, String day, String startTime, int duration,
            int availableSpaces) {
        this.sessionID = sessionCounter;
        sessionCounter++;
        this.sessionName = sessionName;
        this.levelOfFitness = levelOfFitness;
        this.day = day;
        this.startTime = startTime;
        this.duration = duration;
        this.availableSpaces = availableSpaces;

    }

    // Getters
    public int getSessionID() {
        return sessionID;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getLevelOfFitness() {
        return levelOfFitness;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    // Registering a customer
    public boolean register() {
        if (availableSpaces > 0) {
            availableSpaces--;
            return true;
        } else {
            return false; // if there are no spaces left
        }
    }

    // Cancelling a registration
    public boolean cancel() {
        availableSpaces++;
        return true;
    }

    // Prints session details
    public void printDetails() {
        System.out.println("Session ID: " + sessionID + " || " + sessionName + " || " + levelOfFitness + " || " + day
                + " || " + startTime + " || Duration " + duration + " mins || Spaces Left: " + availableSpaces);
    }

}



