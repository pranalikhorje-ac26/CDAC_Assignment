public class MoveZeros {

    public static void main(String[] args) {

        int[] arr = {0, 5, 0, 3, 8, 0, 2};

        int index = 0;

        // Move non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill remaining positions with zero
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        // Display array
        System.out.print("Output: ");

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}