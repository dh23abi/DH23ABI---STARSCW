import java.util.ArrayList;

import java.util.ArrayList;

/**This class implements the STARS interface
 *
 * @author A.A.Marczyk 
 * @version 09/11/21
 **/
public class Resort implements STARS
{
    private String location;
    private ArrayList<Planet> planets;
    private ArrayList<Shuttle> shuttles;
    private ArrayList<Permit> permits;

    /** constructor
     */
    public Resort(String loc) 
    {
        location = loc;
        planets = new ArrayList<>();
        shuttles = new ArrayList<>();
        permits = new ArrayList<>();
        loadPlanets();
        setUpShuttles();
        loadPermits();
    }
    
    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, or "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    public String toString()
    {
        if (planets.isEmpty()) {
            return "No planets found.";
        }

        StringBuilder sb = new StringBuilder("Location: " + location + "\n");
        for (Planet planet : planets) {
            sb.append(planet.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    public String getPermitDetails(int permitId)
    {
        Permit permit = getPermit(permitId);
        if (permit != null) {
            return permit.toString();
        }
        return "No such permit";
    }

    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
    public String getPermitLocation(int tr)
    {
        for (Planet planet : planets) {
            if (planet.findPermitById(tr) != null) {
                return planet.getName();
            }
        }
        return null;
    }
    
    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    public int getPlanetNumber(String ww)
    {
        Planet planet = getPlanet(ww);
        if (planet != null) {
            return planet.getId();
        }
        return -1;
    }
                
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    public String getAllPermitsOnOnePlanet(String planet)
    {
        Planet target = getPlanet(planet);
        if (target != null) {
            return target.getPermitDetails();
        }
        return "No such planet";
    } 

    /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
     */
    public boolean canTravel(int trId, String shtlCode)
    {   
        Permit permit = getPermit(trId);
        Shuttle shuttle = getShuttle(shtlCode);
        
        if (permit != null && shuttle != null) {
            return shuttle.canTravel(permit);
        }
        return false;
    }     

    /**Returns the result of a permit requesting to move by Shuttle.
     */
    public String travel(int pPermitId, String shtlCode )
    {   
        Permit permit = getPermit(pPermitId);
        Shuttle shuttle = getShuttle(shtlCode);
        
        if (permit == null) {
            return "Permit not found";
        }
        if (shuttle == null) {
            return "Shuttle not found";
        }
        return shuttle.travel(permit);
    } 
         
    /** Allows a permit to top up their tokens.
     */
    public void topUpTokens(int id, int tkns)
    {
        Permit permit = getPermit(id);
        if (permit != null) {
            permit.addTokens(tkns);
        }
    }
    
    /** Allows the points on a permit to be converted to tokens (4 points = 1 token)
     */
    public void convertPoints(int id)
    {
        Permit permit = getPermit(id);
        if (permit != null) {
            permit.convertPointsToTokens();
        }
    } 
   
    //***************private methods**************
    private void loadPlanets()
    {
        planets.add(new Planet(0, "Home", 0, 1000));
        planets.add(new Planet(1, "Sprite", 1, 100));
        planets.add(new Planet(2, "Fanta", 3, 50));
        planets.add(new Planet(3, "Coke", 5, 75));
        // Add more planets as per specification...
    }
    
    private void setUpShuttles()
    {
        shuttles.add(new Shuttle("ABC1", planets.get(0), planets.get(1)));
        shuttles.add(new Shuttle("DEF2", planets.get(1), planets.get(2)));
        shuttles.add(new Shuttle("XYZ3", planets.get(2), planets.get(3)));
        // Add more shuttles as per specification...
    }
    
    private void loadPermits()
    {
        permits.add(new Permit(1000, "Lynn", 5, 6));
        permits.add(new Permit(1001, "May", 3, 20));
        permits.add(new Permit(1002, "Nils", 10, 0));
        // Add more permits as per specification...
        for (Permit permit : permits) {
            planets.get(0).arrive(permit); // Add all permits to the "Home" planet
        }
    }
 
    /** Returns the permit with the permit id specified by the parameter
     */
    public Permit getPermit(int id)
    {
        for (Permit permit : permits) {
            if (permit.getId() == id) {
                return permit;
            }
        }
        return null;
    }
    
    /** Returns the planet with the name specified by the parameter
     */
    private Planet getPlanet(String planetName)
    {
        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                return planet;
            }
        }
        return null;
    }
    
    /** Returns the shuttle with the specified code
     */
    private Shuttle getShuttle(String shut)
    {
        for (Shuttle shuttle : shuttles) {
            if (shuttle.getCode().equalsIgnoreCase(shut)) {
                return shuttle;
            }
        }
        return null;
    }
}