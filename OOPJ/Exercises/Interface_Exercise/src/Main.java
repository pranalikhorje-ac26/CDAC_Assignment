interface RegularPolygon {

    // Abstract methods
    int getNumSides();

    double getSideLength();

    // Static method
    static int totalSides(RegularPolygon[] polygons) {

        int total = 0;

        for (RegularPolygon polygon : polygons) 
        {
            total = total + polygon.getNumSides();
        }

        return total;
    }

    // Default method - perimeter
    default double getPerimeter()
    {

        return getNumSides() * getSideLength();
    }

    //  Default method - interior angle
    default double getInteriorAngle() 
    {
        int n = getNumSides();
        return ((n - 2) * Math.PI) / n;
    }
}


// EquilateralTriangle class
class EquilateralTriangle implements RegularPolygon
{
    private double sideLength;
    public EquilateralTriangle(double sideLength)
    {
        this.sideLength = sideLength;
    }

    @Override
    public int getNumSides() 
    {
        return 3;
    }

    @Override
    public double getSideLength() 
    {
        return sideLength;
    }
}


// Square class
class Square implements RegularPolygon 
{
    private double sideLength;
    public Square(double sideLength) 
    {
        this.sideLength = sideLength;
    }

    @Override
    public int getNumSides()
    {
        return 4;
    }

    @Override
    public double getSideLength() 
    {
        return sideLength;
    }
}


// Main class
public class Main 
{	
    public static void main(String[] args) 
    {
        EquilateralTriangle triangle = new EquilateralTriangle(5);

        Square square = new Square(4);

        System.out.println("Triangle");
        System.out.println("Number of sides: "
                + triangle.getNumSides());

        System.out.println("Side length: "+ triangle.getSideLength());

        System.out.println("Perimeter: " + triangle.getPerimeter());

        System.out.println("Interior angle: "+ triangle.getInteriorAngle());


        System.out.println("\nSquare");
        System.out.println("Number of sides: "+ square.getNumSides());

        System.out.println("Side length: "+ square.getSideLength());

        System.out.println("Perimeter: "+ square.getPerimeter());

        System.out.println("Interior angle: "+ square.getInteriorAngle());


        // Array of RegularPolygon
        RegularPolygon[] polygons = { triangle,square};

        // Calling static method
        int total = RegularPolygon.totalSides(polygons);

        System.out.println("\nTotal number of sides: " + total);
    }
}
