
class Rectangle
{
    int length, breadth;

    Rectangle(int length, int breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    int area()
    {
        return length * breadth;
    }

    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(5, 8);

        System.out.println("Area of first rectangle = " + r1.area());
        System.out.println("Area of second rectangle = " + r2.area());
    }
}