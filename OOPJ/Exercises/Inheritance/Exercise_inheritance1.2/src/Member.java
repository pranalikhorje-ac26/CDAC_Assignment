public class Member
{
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private double salary;

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int a)
    {
        age = a;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String p)
    {
        phoneNumber = p;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String ad)
    {
        address = ad;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double s)
    {
        salary = s;
    }

    public void printSalary()
    {
        System.out.println("Salary : " + salary);
    }
}
