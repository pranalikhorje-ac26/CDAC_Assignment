
public class BankUtils {

    // Count number of digits
    static int countDigits(long n) {

        // Handle negative number
        if (n < 0) {
            n = -n;
        }

        // Base case
        if (n < 10) {
            return 1;
        }

        // Recursive case
        return 1 + countDigits(n / 10);
    }

    // Sum of digits
    static int sumDigits(long n) {

        // Handle negative number
        if (n < 0) {
            n = -n;
        }

        // Base case
        if (n < 10) {
            return (int) n;
        }

        // Recursive case
        return (int) (n % 10) + sumDigits(n / 10);
    }

    // Digital root
    static int digitalRoot(long n) {

        // Handle negative number
        if (n < 0) {
            n = -n;
        }

        // Base case
        if (n < 10) {
            return (int) n;
        }

        // Find sum of digits
        int sum = sumDigits(n);

        // Recursively reduce the sum
        return digitalRoot(sum);
    }

    // Mask account number
    static String mask(String acc) {

        // Base case
        if (acc.length() <= 4) {
            return acc;
        }

        // Recursive case
        return "X" + mask(acc.substring(1));
    }

    // Compound interest
    static double amount(double p, double r, int years) {

        // Base case
        if (years == 0) {
            return p;
        }

        // Recursive case
        return amount(p, r, years - 1) * (1 + r / 100);
    }

    public static void main(String[] args) {

        long n = 4096013;

        System.out.println("Account number : " + n);

        System.out.println( "Number of digits : " + countDigits(n));

        System.out.println( "Sum of digits : " + sumDigits(n));

        System.out.println("Digital root : " + digitalRoot(n));

        String acc = "123456789012";

        System.out.println( "Masked account : " + mask(acc));

        double result = amount(10000, 10, 3);

        System.out.printf("Amount after 3 years : %.2f%n", result);
    }
}
