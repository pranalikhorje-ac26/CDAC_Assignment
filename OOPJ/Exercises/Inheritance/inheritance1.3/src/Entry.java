public class Entry {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 5);

        System.out.println("Rectangle:");

        rectangle.printArea();

        rectangle.printPerimeter();

        Square square = new Square(5);

        System.out.println("\nSquare:");

        square.printArea();

        square.printPerimeter();

    }

}