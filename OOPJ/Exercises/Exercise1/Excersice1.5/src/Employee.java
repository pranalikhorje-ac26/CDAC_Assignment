class Employee
{
    String name;
    int yearOfJoining;
    float salary;
    String address;

    Employee(String name, int yearOfJoining, float salary, String address)
    {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
    }

    void display()
    {
        System.out.println(name + "\t\t" + yearOfJoining + "\t\t" + salary + "\t\t" + address);
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee("Robert", 1994, 50000, "64C-WallStreet");
        Employee e2 = new Employee("Sam", 2000, 60000, "68D-WallStreet");
        Employee e3 = new Employee("John", 1999, 55000, "26B-WallStreet");

        System.out.println("Name\t\tYear of Joining\tSalary\t\tAddress");

        e1.display();
        e2.display();
        e3.display();
    }
}
