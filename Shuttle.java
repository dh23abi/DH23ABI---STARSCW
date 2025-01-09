/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    private String code; // Shuttle code
    private Planet sourcePlanet; // Source planet
    private Planet destinationPlanet; // Destination planet

    // Constructor
    public Shuttle(String code, Planet sourcePlanet, Planet destinationPlanet) {
        this.code = code;
        this.sourcePlanet = sourcePlanet;
        this.destinationPlanet = destinationPlanet;
    }

    // Accessors
    public String getCode() {
        return code;
    }

    public Planet getSourcePlanet() {
        return sourcePlanet;
    }

    public Planet getDestinationPlanet() {
        return destinationPlanet;
    }

    // Check if a permit can travel on the shuttle
    public boolean canTravel(Permit permit) {
        return permit.getLuxuryRating() >= destinationPlanet.getLuxuryRating() &&
               destinationPlanet.hasCapacity() &&
               sourcePlanet.isPermitOnPlanet(permit) &&
               permit.hasEnoughTokens();
    }

    // Process a permit traveling on the shuttle
    public String travel(Permit permit) {
        if (!canTravel(permit)) {
            return "Travel not authorized: Conditions not met.";
        }
        sourcePlanet.leave(permit);
        destinationPlanet.arrive(permit);
        permit.useShuttle();
        return "Travel successful: Permit ID " + permit.getId() +
               " has traveled from " + sourcePlanet.getName() +
               " to " + destinationPlanet.getName();
    }

    // toString method
    @Override
    public String toString() {
        return "Shuttle Code: " + code +
               ", Source Planet: " + sourcePlanet.getName() +
               ", Destination Planet: " + destinationPlanet.getName();
    }
}
