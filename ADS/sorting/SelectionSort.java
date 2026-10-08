import java.util.Scanner;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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

        selectionSort(arr);

        System.out.print("After Sorting: ");
        display(arr);

        sc.close();
    }
}