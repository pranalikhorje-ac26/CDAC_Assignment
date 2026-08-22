import java.util.Scanner;
import java.util.Arrays;
class SearchIndex{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Integer numbers[]=new Integer[5];
		System.out.println("Enter 5 intergers: ");

		for(int i=0;i<5;i++){
			numbers[i]=sc.nextInt();}
		System.out.print("Enter the number to search: ");
		int search=sc.nextInt();
                Arrays.sort(numbers);
	         int index = Arrays.binarySearch(numbers, search);
		if (index >= 0) {
           		 System.out.println("The number " + search + " is found at index " + index);}
		 else {
            System.out.println("Not Found");}

							
}}
