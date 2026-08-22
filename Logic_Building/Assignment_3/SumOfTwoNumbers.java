import java.util.Scanner;
class SumOfTwoNumbers{
	static int sumOfTwoNumbers(int a, int b){
		int sum=a+b;
		return sum;
}
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the first number: ");
	int num1=sc.nextInt();

	System.out.println("Enter the second number: ");
	int num2=sc.nextInt();
	int result=sumOfTwoNumbers(num1,num2);
	System.out.println("the sum of " +num1+ " and " +num2+ " is " +result);}}