public class forloop 
{
	public static void main(String []args) 
	{
		oddNumbers();
		evenNumbers();
		pattern();
		reverseTrangle();
		numberTrangle();
		numberTrangle1();
		reverseNumberTrangle();
	}


static void oddNumbers() {
	System.out.println("======Odd Numbers======");
	for(int iTemp=1;iTemp<=1000;iTemp++)
	{
		if(iTemp%2!=0)
			System.out.print(iTemp+", ");
	}
}

static void evenNumbers()
{
	System.out.println("\n======Even Numbers======");
	for(int iTemp=1;iTemp<=500;iTemp++)
	{
		if(iTemp%2==0)
			System.out.print(iTemp+", ");
	}
}
static void pattern()
{
	System.out.println("\n======Triangle Pattern======");
	for(int iTemp=1;iTemp<=5;iTemp++)
	{
		for(int jTemp=1;jTemp<=iTemp;jTemp++) {
			System.out.print("* ");}
		System.out.println(" ");
	}
}

static void reverseTrangle()
{
	System.out.println("\n======Reverse Triangle Pattern======");
	for(int iTemp=1;iTemp<=5;iTemp++)
	{
		for(int jTemp=5;jTemp>=iTemp;jTemp--) {
			System.out.print("* ");}
		System.out.println();
	}
}


static void numberTrangle()
{
	System.out.println("\n======Number Triangle Pattern======");
	int iNum=1;
	for(int iTemp=1;iTemp<=4;iTemp++)
	{
		for(int jTemp=1;jTemp<=iTemp;jTemp++) 
		{
			System.out.print(iNum+" ");
			iNum++;
		}
		System.out.println();
	}
}

static void numberTrangle1()
{
	System.out.println("\n======Number Triangle Pattern======");
//	int iNum=1;
	for(int iTemp=1;iTemp<=6;iTemp++)
	{
		for(int jTemp=1;jTemp<=iTemp;jTemp++) 
		{
			System.out.print(jTemp+" ");
//			iNum++;
		}
		System.out.println();
	}
}

static void reverseNumberTrangle()
{
	System.out.println("\n======Reverse Number Triangle Pattern======");
	for(int iTemp=6;iTemp>=1;iTemp--)
	{
		for(int jTemp=1;jTemp<=iTemp;jTemp++) 
		{
			System.out.print(jTemp+" ");
		}
		System.out.println();
	}
}


}
