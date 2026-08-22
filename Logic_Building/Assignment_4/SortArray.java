import java.util.Scanner;
import java.util.Arrays;
class SortArray{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int numbers[]=new int[5];
		System.out.println("Enter 5 intergers: ");

		for(int i=0;i<5;i++){
			numbers[i]=sc.nextInt();}
		Arrays.sort(numbers);
		System.out.println("Sorted arrays: ");
		for(int num:numbers){
			System.out.print(" "+num);}
		
}}
