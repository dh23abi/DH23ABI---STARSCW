
 
/**
 * A Permit has an id number, name, a luxury rating, tokens, and points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Permit 
{
    private int id; // Permit ID
    private String name; // Guest name
    private int luxuryRating; // Luxury rating
    private int tokens; // Number of tokens
    private int points; // Number of points

    // Constructor
    public Permit(int id, String name, int luxuryRating, int tokens) {
        this.id = id;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.tokens = tokens;
        this.points = 0; // Points start at 0
    }

    // Accessor methods
    public int getId() {
        return id;
    }

    public int getLuxuryRating() {
        return luxuryRating;
    }

    public int getTokens() {
        return tokens;
    }

    public int getPoints() {
        return points;
    }

    // Add tokens
    public void addTokens(int amount) {
        tokens += amount;
    }

    // Deduct tokens
    public void deductTokens(int amount) {
        if (tokens >= amount) {
            tokens -= amount;
        }
    }

    // Convert points to tokens (4 points = 1 token)
    public void convertPointsToTokens() {
        int tokensToAdd = points / 4;
        tokens += tokensToAdd;
        points %= 4;
    }

    // Update permit details when a shuttle is entered
    public void useShuttle() {
        if (tokens >= 3) {
            deductTokens(3);
            points += 1;
        }
    }

    // Check if the permit has enough tokens for a shuttle journey
    public boolean hasEnoughTokens() {
        return tokens >= 3;
    }

    // toString method
    @Override
    public String toString() {
        return "Permit ID: " + id +
               ", Name: " + name +
               ", Luxury Rating: " + luxuryRating +
               ", Tokens: " + tokens +
               ", Points: " + points;
    }
}

