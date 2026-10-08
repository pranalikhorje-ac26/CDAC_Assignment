import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];

                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        System.out.print("Before Sorting: ");
        display(arr);

        insertionSort(arr);

        System.out.print("After Sorting: ");
        display(arr);

        sc.close();
    }
}