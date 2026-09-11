public class Student {
	
	String name;
	int roll_no;
	String phone_no;
	String address;
	public static void main(String []args)
	{
		Student obj=new Student();
		obj.name="John";
		obj.roll_no=2;
		
		 System.out.println("====== Part A ======");
	     System.out.println("Name: " + obj.name);
	     System.out.println("Roll No: " + obj.roll_no);
	     
	     Student s1=new Student();
	     Student s2=new Student();
	     
	     s1.name="Sam";
	     s1.roll_no=3;
	     s1.phone_no="1234567890";
	     s1.address="Sindhudurg";
	     
	     s2.name="John";
	     s2.roll_no=4;
	     s2.phone_no="2345678901";
	     s2.address="Mumbai";
	     
	     
	     System.out.println("\n====== Part B ======");

	      System.out.println("Student 1");
	      System.out.println("Name: " + s1.name);
	      System.out.println("Roll No: " + s1.roll_no);
	      System.out.println("Phone No: " + s1.phone_no);
	      System.out.println("Address: " + s1.address);

	      System.out.println("\nStudent 2");
	      System.out.println("Name: " + s2.name);
	      System.out.println("Roll No: " + s2.roll_no);
	      System.out.println("Phone No: " + s2.phone_no);
	      System.out.println("Address: " + s2.address);
	     
	
	}
}
