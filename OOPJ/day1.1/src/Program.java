public class Program {

    public static void main(String[] args) {

        System.out.println("Enter the first number");
        float num1 = ConsoleInput.getFloat();

        System.out.println("Enter the second number");
        float num2 = ConsoleInput.getFloat();

        Calculator objCalculator = new Calculator();

        float addition = objCalculator.add(num1, num2);
        float subtraction = objCalculator.subtract(num1, num2);
        float multiplication = objCalculator.multiply(num1, num2);
        float division = objCalculator.divide(num1, num2);

        System.out.println("Addition = " + addition);
        System.out.println("Subtraction = " + subtraction);
        System.out.println("Multiplication = " + multiplication);
        System.out.println("Division = " + division);
    }
}
