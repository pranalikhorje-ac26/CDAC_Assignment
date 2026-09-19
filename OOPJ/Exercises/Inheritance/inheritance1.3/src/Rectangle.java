public class Rectangle {

    protected float length;
    protected float breadth;

    public Rectangle(float length, float breadth) {

        this.length = length;
        this.breadth = breadth;

    }
    public void printArea()
    {
        System.out.println("Area : " + (length * breadth));
    }

    public void printPerimeter() 
    {
        System.out.println("Perimeter : "+ (2 * (length + breadth)));

    }
}