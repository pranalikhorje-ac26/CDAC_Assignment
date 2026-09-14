abstract class Employee
{
    protected String name;
    protected String address;
    protected int age;
    protected boolean gender;
    protected float basicSalary;

    public Employee(String n, String a, int ag, boolean g, float salary)
    {
        name = n;
        address = a;
        age = ag;
        gender = g;
        basicSalary = salary;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isGender()
    {
        return gender;
    }

    public float getBasicSalary()
    {
        return basicSalary;
    }

    public abstract String getDesignation();

    public void display()
    {
        System.out.println("Name         : " + name);
        System.out.println("Address      : " + address);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Designation  : " + getDesignation());
    }
}


// Manager
class Manager extends Employee
{
    public Manager(String n, String a, int ag, boolean g, float salary)
    {
        super(n, a, ag, g, salary);
    }

    @Override
    public String getDesignation()
    {
        return "Manager";
    }
}


// Engineer
class Engineer extends Employee
{
    public Engineer(String n, String a, int ag, boolean g, float salary)
    {
        super(n, a, ag, g, salary);
    }

    @Override
    public String getDesignation()
    {
        return "Engineer";
    }
}


// Sales Person
class SalesPerson extends Employee
{
    public SalesPerson(String n, String a, int ag, boolean g, float salary)
    {
        super(n, a, ag, g, salary);
    }

    @Override
    public String getDesignation()
    {
        return "Sales Person";
    }
}


// Main class
public class Program
{
    static Employee[] arrEmployee = new Employee[40];

    static int count = 0;
    static int current = -1;


    public static void main(String[] args)
    {
        int choice;

        do
        {
            System.out.println("\n==============================");
            System.out.println("      EMPLOYEE MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Exit");

            System.out.print("Enter choice : ");
            choice = ConsoleInput.getInt();

            switch(choice)
            {
                case 1:
                    addMenu();
                    break;

                case 2:
                    displayMenu();
                    break;

                case 3:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while(choice != 3);
    }


    // ADD MENU
    static void addMenu()
    {
        int choice;

        do
        {
            System.out.println("\n---------- ADD EMPLOYEE ----------");

            System.out.println("1. Manager");
            System.out.println("2. Engineer");
            System.out.println("3. Sales Person");
            System.out.println("4. Exit to Main Menu");

            System.out.print("Enter choice : ");
            choice = ConsoleInput.getInt();

            switch(choice)
            {
                case 1:
                    addEmployee(1);
                    break;

                case 2:
                    addEmployee(2);
                    break;

                case 3:
                    addEmployee(3);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while(choice != 4);
    }


    // ADD EMPLOYEE
    static void addEmployee(int type)
    {
        if(count == 40)
        {
            System.out.println("Employee array is full.");
            return;
        }

        System.out.print("Enter name : ");
        String name = ConsoleInput.getString();

        System.out.print("Enter address : ");
        String address = ConsoleInput.getString();

        System.out.print("Enter age : ");
        int age = ConsoleInput.getInt();

        System.out.print("Enter gender (true/false) : ");
        boolean gender = Boolean.parseBoolean(ConsoleInput.getString());

        System.out.print("Enter basic salary : ");
        float salary = ConsoleInput.getFloat();


        if(type == 1)
        {
            arrEmployee[count] =
                new Manager(name, address, age, gender, salary);
        }
        else if(type == 2)
        {
            arrEmployee[count] =
                new Engineer(name, address, age, gender, salary);
        }
        else
        {
            arrEmployee[count] =
                new SalesPerson(name, address, age, gender, salary);
        }

        count++;

        if(current == -1)
            current = 0;

        System.out.println("Employee added successfully.");
    }


    // DISPLAY MENU
    static void displayMenu()
    {
        int choice;

        do
        {
            System.out.println("\n---------- DISPLAY ----------");

            System.out.println("1. All Employees");
            System.out.println("2. First Employee");
            System.out.println("3. Next Employee");
            System.out.println("4. Previous Employee");
            System.out.println("5. Last Employee");
            System.out.println("6. Exit to Main Menu");

            System.out.print("Enter choice : ");
            choice = ConsoleInput.getInt();

            switch(choice)
            {
                case 1:
                    displayAll();
                    break;

                case 2:
                    firstEmployee();
                    break;

                case 3:
                    nextEmployee();
                    break;

                case 4:
                    previousEmployee();
                    break;

                case 5:
                    lastEmployee();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while(choice != 6);
    }


    // DISPLAY ALL
    static void displayAll()
    {
        if(count == 0)
        {
            System.out.println("No employees available.");
            return;
        }

        for(int i = 0; i < count; i++)
        {
            System.out.println("\n----------------------------");
            arrEmployee[i].display();
        }
    }


    // FIRST EMPLOYEE
    static void firstEmployee()
    {
        if(count == 0)
        {
            System.out.println("No employees available.");
            return;
        }

        current = 0;

        System.out.println("\nFirst Employee:");
        arrEmployee[current].display();
    }


    // NEXT EMPLOYEE
    static void nextEmployee()
    {
        if(count == 0)
        {
            System.out.println("No employees available.");
            return;
        }

        if(current < count - 1)
        {
            current++;
            arrEmployee[current].display();
        }
        else
        {
            System.out.println("Already at last employee.");
        }
    }


    // PREVIOUS EMPLOYEE
    static void previousEmployee()
    {
        if(count == 0)
        {
            System.out.println("No employees available.");
            return;
        }

        if(current > 0)
        {
            current--;
            arrEmployee[current].display();
        }
        else
        {
            System.out.println("Already at first employee.");
        }
    }


    // LAST EMPLOYEE
    static void lastEmployee()
    {
        if(count == 0)
        {
            System.out.println("No employees available.");
            return;
        }

        current = count - 1;

        System.out.println("\nLast Employee:");
        arrEmployee[current].display();
    }
}
