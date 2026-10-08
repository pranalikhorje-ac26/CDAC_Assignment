import java.util.Scanner;

public class QuickSort{
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int p =partition(arr, low, high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
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

        quickSort(arr, 0, arr.length - 1);

        System.out.print("After Sorting: ");
        display(arr);

        sc.close();


    }


}