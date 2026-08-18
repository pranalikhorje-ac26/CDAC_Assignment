public class LargestNumber {
    public static void main(String args[]) {
        int a = 25;
        int b = 40;
        int c = 30;
        if (a >= b && a >= c) {
            System.out.println("Largest number is: " + a);}
        else if (b >= a && b >= c) {
            System.out.println("Largest number is: " + b);}
        else {
            System.out.println("Largest number is: " + c);
        }}}