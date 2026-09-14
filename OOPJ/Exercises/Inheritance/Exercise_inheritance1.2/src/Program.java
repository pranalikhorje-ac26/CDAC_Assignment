public class Program
{
    public static void main(String args[])
    {
        PrimeMembers member = new PrimeMembers();

        System.out.print("Enter Name: ");
        member.setName(ConsoleInput.getString());

        System.out.print("Enter Age: ");
        member.setAge(ConsoleInput.getInt());

        System.out.print("Enter Phone Number: ");
        member.setPhoneNumber(ConsoleInput.getString());

        System.out.print("Enter Address: ");
        member.setAddress(ConsoleInput.getString());

        System.out.print("Enter Salary: ");
        member.setSalary(ConsoleInput.getFloat());

        System.out.print("Enter Joining Year: ");
        member.setJoiningYear(ConsoleInput.getInt());

        System.out.print("Enter Joining Fees: ");
        member.setJoiningFees(ConsoleInput.getFloat());

        System.out.print("Is Active (true/false): ");
        member.setIsActive(Boolean.parseBoolean(ConsoleInput.getString()));

        System.out.println("\n----- Member Details -----");
        member.display();

        System.out.println();
        member.printSalary();
    }
}