public class Program {
	public static void main(String []args)
	{
		date objDate = new date();
		System.out.println("Enter the Day: ");
		int day = ConsoleInput.getInt();
		
		System.out.println("Enter the month: ");
		int month = ConsoleInput.getInt();
		
		System.out.println("Enter the year: ");
		int year = ConsoleInput.getInt();
		
		objDate.setDate(day,month,year);
		System.out.println(objDate.getDay()+ "/"+objDate.getMonth()+"/"+objDate.getYear());
		int choice;
        do {
            System.out.println("======== MENU ======");
            System.out.println("1. Add Day");
            System.out.println("2. Add Month");
            System.out.println("3. Add Year");
            System.out.println("4. Display");
            System.out.println("5. compare");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            choice = ConsoleInput.getInt();
            switch (choice) {
            case 1:
                System.out.println("Enter number of days:");
                int days = ConsoleInput.getInt();
                AddDays.addDay(objDate, days);
                Display.display(objDate);
                break;

            case 2:
                System.out.println("Enter number of months:");
                int months = ConsoleInput.getInt();
                AddMonths.addMonth(objDate, months);
                Display.display(objDate);
                break;

            case 3:
                System.out.println("Enter number of years:");
                int years = ConsoleInput.getInt();
                AddYear.addYear(objDate, years);
                Display.display(objDate);
                break;

            case 4:
                Display.display(objDate);
                break;

            case 5:
                System.out.println("Compare");
                break;
                
            case 6:
                System.out.println("Exit");
                break;
                
            default:
                System.out.println("Invalid choice!");
            }
        } while (choice != 6);
	System.out.println(objDate.getDay()+ "/"+objDate.getMonth()+"/"+objDate.getYear());
	}
}
