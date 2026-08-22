import java.util.Scanner;

class CountVowels {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String word = sc.nextLine();
	int count=0;
        for (int i = 0; i <word.length() ; i++) {
           char ch= word.charAt(i);
	 if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
        }}

        System.out.println("The number of vowels in '" +word + "' is: " + count);}}