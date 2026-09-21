import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();

        // Add colors
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Original List: " + colors);

        //  Insert element at first position
        colors.add(0, "Pink");
        System.out.println("After inserting at first position: " + colors);

        // Retrieve element at specified index
        System.out.println("Element at index 2: " + colors.get(2));

        // Update an element
        colors.set(1, "Orange");
        System.out.println("After updating index 1: " + colors);

        //Remove third element
        colors.remove(2);
        System.out.println("After removing third element: " + colors);

        //  Search an element
        String searchColor = "Blue";

        if (colors.contains(searchColor)) {
            System.out.println(searchColor + " is present in the list.");
        } else {
            System.out.println(searchColor + " is not present in the list.");
        }

        //  Sort the ArrayList
        Collections.sort(colors);
        System.out.println("After sorting: " + colors);

        //  Copy one ArrayList into another
        ArrayList<String> copiedColors = new ArrayList<>(colors.size());

        // Add empty elements first
        for (int i = 0; i < colors.size(); i++) {
            copiedColors.add("");
        }

        Collections.copy(copiedColors, colors);

        System.out.println("Copied List: " + copiedColors);

        //  Shuffle elements
        Collections.shuffle(colors);
        System.out.println("After shuffling: " + colors);

        //  Reverse elements
        Collections.reverse(colors);
        System.out.println("After reversing: " + colors);
    }
}