public class PrimeMembers extends Member
{
    private int joiningYear;
    private double joiningFees;
    private boolean isActive;

    // Getters and Setters
    public int getJoiningYear()
    {
        return joiningYear;
    }

    public void setJoiningYear(int y)
    {
        joiningYear = y;
    }

    public double getJoiningFees()
    {
        return joiningFees;
    }

    public void setJoiningFees(double f)
    {
        joiningFees = f;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean active)
    {
        isActive = active;
    }

    public void display()
    {
        System.out.println("Name          : " + getName());
        System.out.println("Age           : " + getAge());
        System.out.println("Phone Number  : " + getPhoneNumber());
        System.out.println("Address       : " + getAddress());
        System.out.println("Salary        : " + getSalary());
        System.out.println("Joining Year  : " + joiningYear);
        System.out.println("Joining Fees  : " + joiningFees);
        System.out.println("Is Active     : " + isActive);
    }
}