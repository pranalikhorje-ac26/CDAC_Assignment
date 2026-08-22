import java.util.Scanner;

class PrintStringNames {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String names[] = new String[5];
        System.out.println("Enter 5 names: ");

        for (int i = 0; i < 5; i++) {
            names[i] = sc.next();}
	System.out.print("Names are: ");
        for (String name : names) {
	System.out.println(name);
    }}
}