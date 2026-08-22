import java.util.Scanner;

class ReverseString {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String word = sc.nextLine();
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        System.out.println("Reversed string: " + reverse);
    }
}