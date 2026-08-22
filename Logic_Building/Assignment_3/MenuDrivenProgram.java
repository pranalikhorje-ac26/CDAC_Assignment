import java.util.Scanner;

class MenuDrivenProgram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Grade Evaluation System");
            System.out.println("2. Leap Year Check");
            System.out.println("3. Day of the Week");
            System.out.println("4. Identify Default Values of Variables");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            switch (choice) {

                case 1:
                   //Grade Evaluation 

                    System.out.println("Enter marks:");
                    int marks = sc.nextInt();

                    if (marks >= 90) {
                        System.out.println("Grade: A");
                    } else if (marks >= 80) {
                        System.out.println("Grade: B");
                    } else if (marks >= 70) {
                        System.out.println("Grade: C");
                    } else if (marks >= 60) {
                        System.out.println("Grade: D");
                    } else {
                        System.out.println("Grade: F");
                    }
                    break;

                    case 2:
                    //  Leap Year Check

                    System.out.println("Enter year:");
                    int year = sc.nextInt();

                    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {

                        System.out.println(year + " is a Leap Year");
                    } else {
                        System.out.println(year + " is not a Leap Year");
                    }
                    break;

                    case 3:
                    //  Day of the Week

                    System.out.println("Enter day number (1-7):");
                    int day = sc.nextInt();

                    switch (day) {
                        case 1:
                            System.out.println("Monday");
                            break;
                        case 2:
                            System.out.println("Tuesday");
                            break;
                        case 3:
                            System.out.println("Wednesday");
                            break;
                        case 4:
                            System.out.println("Thursday");
                            break;
                        case 5:
                            System.out.println("Friday");
                            break;
                        case 6:
                            System.out.println("Saturday");
                            break;
                        case 7:
                            System.out.println("Sunday");
                            break;

                        default:
                            System.out.println("Invalid day number");}
                    break;

                      case 4:
                    //Default Values of Variables

                    class DefaultValues {
                        int number;
                        double decimal;
                        boolean flag;
                        char character;
                        String text;}

                    DefaultValues obj = new DefaultValues();
                    System.out.println("Default int value: " + obj.number);
                    System.out.println("Default double value: " + obj.decimal);
                    System.out.println("Default boolean value: " + obj.flag);
                    System.out.println("Default char value: [" + obj.character + "]");
                    System.out.println("Default String value: " + obj.text);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
} while (choice != 5);

        sc.close();}}