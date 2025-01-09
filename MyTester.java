 
 import java.util.*;

/**
 * Write a description of class MyTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   
    private void doTest1()
    {
        // Create a resort
        Resort resort = new Resort("Wayward Planets");

        // Display details of all planets and permits
        System.out.println("Resort Details:");
        System.out.println(resort);

        // Test getting details of a specific permit
        System.out.println("\nTesting getPermitDetails:");
        System.out.println(resort.getPermitDetails(1000));
        System.out.println(resort.getPermitDetails(9999)); // Nonexistent permit

        // Test getting permit location
        System.out.println("\nTesting getPermitLocation:");
        System.out.println("Location of Permit 1000: " + resort.getPermitLocation(1000));
        System.out.println("Location of Permit 9999: " + resort.getPermitLocation(9999)); // Nonexistent permit

        // Test getting all permits on a specific planet
        System.out.println("\nTesting getAllPermitsOnOnePlanet:");
        System.out.println(resort.getAllPermitsOnOnePlanet("Home"));
        System.out.println(resort.getAllPermitsOnOnePlanet("Nonexistent")); // Nonexistent planet

        // Test topping up tokens
        System.out.println("\nTesting topUpTokens:");
        resort.topUpTokens(1000, 10);
        System.out.println("Permit 1000 after topping up tokens: " + resort.getPermitDetails(1000));

        // Test converting points to tokens
        System.out.println("\nTesting convertPoints:");
        resort.convertPoints(1000);
        System.out.println("Permit 1000 after converting points: " + resort.getPermitDetails(1000));

        // Test canTravel method
        System.out.println("\nTesting canTravel:");
        System.out.println("Can Permit 1000 travel using ABC1 shuttle? " + resort.canTravel(1000, "ABC1"));
        System.out.println("Can Permit 9999 travel using ABC1 shuttle? " + resort.canTravel(9999, "ABC1")); // Nonexistent permit
        System.out.println("Can Permit 1000 travel using Nonexistent shuttle? " + resort.canTravel(1000, "Nonexistent")); // Nonexistent shuttle

        // Test travel method
        System.out.println("\nTesting travel:");
        System.out.println(resort.travel(1000, "ABC1")); // Successful travel
        System.out.println(resort.travel(9999, "ABC1")); // Nonexistent permit
        System.out.println(resort.travel(1000, "Nonexistent")); // Nonexistent shuttle
    }
     
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
}
