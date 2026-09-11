class Triangle {
    double side1, side2, side3;

    // Parameterized constructor
    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Method to calculate perimeter
    double perimeter() {
        return side1 + side2 + side3;
    }

    // Method to calculate area using Heron's formula
    double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static void main(String[] args) {
        // Creating object and passing three sides
        Triangle t = new Triangle(3, 4, 5);

        System.out.println("Perimeter of Triangle = " + t.perimeter());
        System.out.println("Area of Triangle = " + t.area());
    }
}