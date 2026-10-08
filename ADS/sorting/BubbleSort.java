import java.util.Scanner;

public class BubbleSort{
    public static void bubbleSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void display(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        System.out.print("Before Sorting: ");
        display(arr);

        bubbleSort(arr);

        System.out.print("After Sorting: ");
        display(arr);

        sc.close();


    }
}