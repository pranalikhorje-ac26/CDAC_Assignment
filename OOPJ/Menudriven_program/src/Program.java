public class Program 
{
    public static void main(String[] args) 
    {
        date objDate = new date();
        System.out.println("Enter Day:");
        int day = ConsoleInput.getInt();

        System.out.println("Enter Month:");
        int month = ConsoleInput.getInt();

        System.out.println("Enter Year:");
        int year = ConsoleInput.getInt();

        objDate.setDate(day, month, year);

        int choice;
        do
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Day");
            System.out.println("2. Add Month");
            System.out.println("3. Add Year");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.println("Enter Choice:");

            choice = ConsoleInput.getInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter days:");
                    objDate.addDay(ConsoleInput.getInt());
                    objDate.display();
                    break;

                case 2:
                    System.out.println("Enter months:");
                    objDate.addMonth(ConsoleInput.getInt());
                    objDate.display();
                    break;

                case 3:
                    System.out.println("Enter years:");
                    objDate.addYear(ConsoleInput.getInt());
                    objDate.display();
                    break;

                case 4:
                    objDate.display();
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
