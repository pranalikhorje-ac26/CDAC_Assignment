import java.util.Scanner;
import java.util.Arrays;

class AvgElemts {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int numbers[] = new int[5];
        System.out.println("Enter 5 integers: ");

        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();}
		int sum=0;
	for (int num : numbers) {
            sum = sum + num;
        }

        // Calculate average
        double average = (double) sum / numbers.length;

        System.out.println("Average of elements = " + average);
            }
}