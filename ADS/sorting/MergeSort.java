import java.util.Scanner;

public class MergeSort{
    public static void merge(int[]arr, int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int[]temp=new int[high-low+1];
        while(i<=mid&& j<=high){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=high){
            j++;
            k++;;
        }
        for(i=low , k=0; i<=high; i++, k++) {
            arr[i]=temp[k];
        }
    }
    public static void mergeSort(int[]arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void display(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[]arr={38, 27, 43, 3, 9, 82, 10};
        System.out.print("Before Sorting: ");
        display(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("After Sorting: ");
        display(arr);

        sc.close();

    }}