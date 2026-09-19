public class Entry {

    public static void main(String[] args) {

        String string = "The quick brown fox jumps";

        System.out.println("The given string is: " + string);

        String reverseString = "";

        for (int index = string.length() - 1; index >= 0; index--) {

            reverseString = reverseString + string.charAt(index);

        }

        System.out.println("The string in reverse order is:");

        System.out.println(reverseString);

    }

}