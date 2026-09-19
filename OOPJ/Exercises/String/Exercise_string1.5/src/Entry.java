public class Entry {

    public static void main(String[] args) {

        String string = "The quick brown fox jumps over the lazy dog.";

        System.out.println("Original string: " + string);

        String newString = string.replaceAll("fox", "cat");

        System.out.println("New String: " + newString);

    }

}