class parent
{
	void parentMethod()
	{
		System.out.println("This is parent class");;
	}
}

class child extends parent
{
	void childMethod()
	{
		System.out.println("This is child class");
	}
}

public class Program 
{
	public static void main(String []args)
	{
		parent p = new parent();
		child c = new child();
		p.parentMethod();
		c.childMethod();
		c.parentMethod();
	}
}
