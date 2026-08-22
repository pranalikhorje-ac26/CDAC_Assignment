import java.util.Scanner;

class Palindrome {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String word = sc.nextLine();
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }
	if(word.equals(reverse)){	
       		System.out.println("The String '"+word+"' is a palindrome.");
	}else{
		System.out.println("Not Palindrome");}
    }
}