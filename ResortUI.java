import java.util.*;

/**
 * ResortUI handles the user interface for the Wayward Planets resort.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{
    private Scanner reader = new Scanner(System.in);
    private STARS wayward = new Resort("Wayward Planets");
    
    private void runUI()
    {
        int choice = getOption();        
        while (choice != 0)
        {            
            try {
                // Process choice
                if      (choice == 1) { listAllPlanets(); }
                else if (choice == 2) { listOnePlanet(); }
                else if (choice == 3) { findPermitLocation(); }
                else if (choice == 4) { tryTravel(); }
                else if (choice == 5) { travelNow(); }
                else if (choice == 6) { getPermitInfo(); }
                else if (choice == 7) { updateTokens(); }
                else if (choice == 8) { convertPoints(); }
                else { System.out.println("Invalid choice. Please try again."); }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                reader.nextLine(); // Clear input buffer
            }
            choice = getOption(); // Prompt for next choice
        }
        System.out.println("\nThank-you");
    }
    
    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all planet details");
        System.out.println("2. List all permits on one planet");
        System.out.println("3. Find permit location");
        System.out.println("4. Say if permit can move by shuttle");
        System.out.println("5. Move a permit by shuttle");
        System.out.println("6. Get permit details");
        System.out.println("7. Top up tokens");
        System.out.println("8. Convert Points");
        System.out.print("Enter your choice: ");
        
        while (!reader.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            reader.nextLine();
        }
        int option = reader.nextInt();
        reader.nextLine(); // Consume newline
        return option;
    }
    
    private void listAllPlanets()
    {
        System.out.println(wayward.toString());
    }

    private void listOnePlanet()
    {
        System.out.print("Enter the name of the planet: ");
        String planetName = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(planetName));
    }
    
    private void findPermitLocation()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        reader.nextLine();
        String location = wayward.getPermitLocation(permitId);
        if (location != null) {
            System.out.println("Permit is located at: " + location);
        } else {
            System.out.println("Permit not found.");
        }
    }

    private void tryTravel()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        reader.nextLine();
        System.out.print("Enter shuttle code: ");
        String shuttleCode = reader.nextLine();
        boolean canTravel = wayward.canTravel(permitId, shuttleCode);
        System.out.println(canTravel ? "Permit can travel on the shuttle." : "Permit cannot travel on the shuttle.");
    }
    
    private void travelNow()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        reader.nextLine();
        System.out.print("Enter shuttle code: ");
        String shuttleCode = reader.nextLine();
        System.out.println(wayward.travel(permitId, shuttleCode));
    }

    private void getPermitInfo()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        System.out.println(wayward.getPermitDetails(permitId));
    }

    private void updateTokens()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        System.out.print("Enter the number of tokens to add: ");
        int tokens = reader.nextInt();
        wayward.topUpTokens(permitId, tokens);
        System.out.println("Tokens updated successfully.");
    }
    
    private void convertPoints()
    {
        System.out.print("Enter permit id: ");
        int permitId = reader.nextInt();
        wayward.convertPoints(permitId);
        System.out.println("Points converted to tokens successfully.");
    }
    
    public static void main(String[] args)
    {
        ResortUI ui = new ResortUI();
        ui.runUI();
    }
}