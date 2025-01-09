import java.util.ArrayList;

/**
 * A planet is part of a STARS resort. Each planet has a name, a luxury rating,
 * and a capacity which represents the maximum number of permits(people) who can be on the
 * planet at any one time. Each planet must maintain a list of all permits(people)
 * currently on the planet. These lists are updated whenever permits arrive or leave
 * a planet, so that it is always possible to say how many permits(people) are on the planet
 * and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Planet 
{
    private int id; // Planet reference number
    private String name; // Planet name
    private int luxuryRating; // Luxury rating of the planet
    private int capacity; // Maximum number of permits the planet can hold
    private ArrayList<Permit> permits; // List of permits currently on the planet

    // Constructor
    public Planet(int id, String name, int luxuryRating, int capacity) {
        this.id = id;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.capacity = capacity;
        this.permits = new ArrayList<>();
    }

    // Accessors
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLuxuryRating() {
        return luxuryRating;
    }

    public int getCapacity() {
        return capacity;
    }

    // Check if the planet has capacity for more permits
    public boolean hasCapacity() {
        return permits.size() < capacity;
    }

    // Add a permit to the planet
    public boolean arrive(Permit permit) {
        if (hasCapacity() && !permits.contains(permit)) {
            permits.add(permit);
            return true;
        }
        return false;
    }

    // Remove a permit from the planet
    public boolean leave(Permit permit) {
        return permits.remove(permit);
    }

    // Check if a specific permit is on the planet
    public boolean isPermitOnPlanet(Permit permit) {
        return permits.contains(permit);
    }

    // Find and return details of a permit on the planet by ID
    public Permit findPermitById(int permitId) {
        for (Permit permit : permits) {
            if (permit.getId() == permitId) {
                return permit;
            }
        }
        return null;
    }

    // Get details of all permits on the planet
    public String getPermitDetails() {
        StringBuilder details = new StringBuilder();
        for (Permit permit : permits) {
            details.append(permit.toString()).append("\n");
        }
        return details.toString();
    }

    // toString method
    @Override
    public String toString() {
        return "Planet ID: " + id +
               ", Name: " + name +
               ", Luxury Rating: " + luxuryRating +
               ", Capacity: " + capacity +
               ", Permits On Planet: " + permits.size() +
               "\n" + getPermitDetails();
    }
}
