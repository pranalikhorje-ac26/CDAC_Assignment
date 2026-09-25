import java.util.Arrays;
import java.util.Random;
import java.time.LocalDate;
import java.util.function.*;

public class LambdaPractice {

    public static void main(String[] args) {

        // Sort String array in alphabetical order
        Consumer<String[]> sortStrings = arr -> Arrays.sort(arr);

        String[] names = {"Rahul", "Amit", "Priya", "Neha"};
        sortStrings.accept(names);

        System.out.println("1. Sorted array: "+ Arrays.toString(names));


        //  Find largest number
        Function<int[], Integer> largest = arr -> {

            int max = arr[0];
            for (int n : arr) {
                if (n > max)
                    max = n;
            }
            return max;
        };

        int[] numbers = {10, 45, 23, 67, 12};
        System.out.println("2. Largest: "+ largest.apply(numbers));


        //  Find smallest number
        Function<int[], Integer> smallest = arr -> {

            int min = arr[0];
            for (int n : arr) {
                if (n < min)
                    min = n;
            }
            return min;
        };

        System.out.println("3. Smallest: "+ smallest.apply(numbers));


        //  Generate 3 digit random number
        Supplier<Integer> randomNumber =() -> new Random().nextInt(900) + 100;

        System.out.println("4. Random number: " + randomNumber.get());


        //  Reverse integer array
        Function<int[], int[]> reverse = arr -> {

            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[arr.length - 1 - i];
            }
            return result;
        };

        int[] reversed = reverse.apply(numbers);
        System.out.println("5. Reverse array: "+ Arrays.toString(reversed));


        // Print current date
        Supplier<LocalDate> currentDate =() -> LocalDate.now();
        System.out.println("6. Current date: "+ currentDate.get());

        //  Check Prime number
        Predicate<Integer> isPrime = n -> {

            if (n < 2)
                return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0)
                    return false;
            }
            return true;
        };

        System.out.println("7. Is 17 prime? "+ isPrime.test(17));


        //Concatenate two strings
        BiFunction<String, String, String> concatenate =(str1, str2) -> str1 + str2;

        System.out.println("8. Concatenated string: "+ concatenate.apply("Hello ", "Java"));
    }
}