
/**
 * Write a description of class PermitTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PermitTester
{
    public static void main(String[] args)
    {
        // Create sample permits
        Permit permit1 = new Permit(1000, "Lynn", 5, 6);
        Permit permit2 = new Permit(1001, "May", 3, 20);
        Permit permit3 = new Permit(1002, "Nils", 10, 0);

        // Test basic details and toString method
        System.out.println("Testing toString:");
        System.out.println(permit1);
        System.out.println(permit2);
        System.out.println(permit3);

        // Test adding tokens
        System.out.println("\nTesting addTokens:");
        permit1.addTokens(10);
        System.out.println("After adding tokens: " + permit1);

        // Test deducting tokens
        System.out.println("\nTesting deductTokens:");
        permit2.deductTokens(5);
        System.out.println("After deducting tokens: " + permit2);

        // Test converting points to tokens
        System.out.println("\nTesting convertPointsToTokens:");
        permit3.addTokens(4); // Adding initial tokens
        permit3.useShuttle(); // Adds a point
        permit3.useShuttle(); // Adds another point
        permit3.useShuttle(); // Adds another point
        permit3.useShuttle(); // Adds another point (4 points total)
        permit3.convertPointsToTokens();
        System.out.println("After converting points: " + permit3);

        // Test if permit has enough tokens
        System.out.println("\nTesting hasEnoughTokens:");
        System.out.println("Permit 1 has enough tokens: " + permit1.hasEnoughTokens());
        System.out.println("Permit 3 has enough tokens: " + permit3.hasEnoughTokens());

        // Test shuttle usage
        System.out.println("\nTesting useShuttle:");
        permit1.useShuttle();
        System.out.println("After using shuttle: " + permit1);
    }
}
