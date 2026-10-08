public class CoinKiosk {

    static long calls = 0;

    // Print all possible coin sequences
    static void printWays(int amount, String coinsSoFar) {

        // Base case
        if (amount == 0) {
            System.out.println(coinsSoFar);
            return;
        }

        // Try Rs.1 coin
        if (amount >= 1) {
            printWays(amount - 1, coinsSoFar + "1 ");
        }

        // Try Rs.2 coin
        if (amount >= 2) {
            printWays(amount - 2, coinsSoFar + "2 ");
        }
    }

    // Count number of ways
    static long countWays(int amount) {

        calls++;

        // Base case
        if (amount == 0) {
            return 1;
        }

        if (amount == 1) {
            return 1;
        }

        // Recursive case
        return countWays(amount - 1) + countWays(amount - 2);
    }

    public static void main(String[] args) {

        int amount = 4;

        System.out.println("Ways to pay " + amount + ":");

        printWays(amount, "");

        calls = 0;

        long ways = countWays(amount);

        System.out.println("Total ways = " + ways);
        System.out.println("CountWays calls = " + calls);

        // Test amount 5
        calls = 0;

        System.out.println("\nAmount = 5");

        System.out.println("Total ways = " + countWays(5) );

        System.out.println("CountWays calls = " + calls);

        // Test amount 10
        calls = 0;

        System.out.println("\nAmount = 10");

        System.out.println("Total ways = " + countWays(10) );

        System.out.println( "CountWays calls = " + calls );

        // Test amount 30
        calls = 0;

        System.out.println("\nAmount = 30");

        System.out.println( "Total ways = " + countWays(30));

        System.out.println("CountWays calls = " + calls);
    }
}