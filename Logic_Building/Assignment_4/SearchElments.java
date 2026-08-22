import java.util.Scanner;
import java.util.Arrays;
class SearchElments{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Integer numbers[]=new Integer[5];
		System.out.println("Enter 5 intergers: ");

		for(int i=0;i<5;i++){
			numbers[i]=sc.nextInt();}
		System.out.print("Enter the number to search: ");
		int search=sc.nextInt();
		if(Arrays.asList(numbers).contains(search)){
			System.out.print("Found");}
		else{
			System.out.print(" Not found");}

							
}}
