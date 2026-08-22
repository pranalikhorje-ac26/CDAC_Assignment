import java.util.Scanner;
class PositiveNumber{
	static void askForPositiveNumber(){
	 int number;
		do{
			 Scanner sc = new Scanner(System.in);
			System.out.println("Enter a positive number: ");
			number=sc.nextInt();}
			
	while(number<=0);
	System.out.println("You Entered a positive number: " +number);
}
public static void main(String args[]){
	askForPositiveNumber();}}