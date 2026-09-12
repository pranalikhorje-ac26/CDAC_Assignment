class Complex
{
    float real, imaginary;

    Complex(float real, float imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    void sum(Complex c)
    {
        System.out.println("Sum = " + (real + c.real) + " + " + (imaginary + c.imaginary) + "i");
    }

    void difference(Complex c)
    {
        System.out.println("Difference = " + (real - c.real) + " + " + (imaginary - c.imaginary) + "i");
    }

    void product(Complex c)
    {
        float r = (real * c.real) - (imaginary * c.imaginary);
        float i = (real * c.imaginary) + (imaginary * c.real);

        System.out.println("Product = " + r + " + " + i + "i");
    }

    public static void main(String[] args)
    {
        System.out.print("Enter real part of first complex number: ");
        float r1 = ConsoleInput.getFloat();

        System.out.print("Enter imaginary part of first complex number: ");
        float i1 = ConsoleInput.getFloat();

        System.out.print("Enter real part of second complex number: ");
        float r2 = ConsoleInput.getFloat();

        System.out.print("Enter imaginary part of second complex number: ");
        float i2 = ConsoleInput.getFloat();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        c1.sum(c2);
        c1.difference(c2);
        c1.product(c2);
    }
}