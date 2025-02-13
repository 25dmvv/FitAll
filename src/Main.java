
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
    public Session(String sessionName, String levelofFitness, String day, String startTime, int duration, int availableSpaces) {
        this.sessionID = sessionCounter++;
        this.sessionName = sessionName;
        this.levelOfFitness = levelOfFitness;
        this.day = day;
        this.startTime = startTime;
        this.duration = duration;
        this.availableSpaces = availableSpaces;
    }
    
}
