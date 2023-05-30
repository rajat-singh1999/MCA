import java.util.Scanner;

class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex other) {
        double realSum = real + other.real;
        double imaginarySum = imaginary + other.imaginary;
        return new Complex(realSum, imaginarySum);
    }

    public Complex subtract(Complex other) {
        double realDiff = real - other.real;
        double imaginaryDiff = imaginary - other.imaginary;
        return new Complex(realDiff, imaginaryDiff);
    }

    public Complex multiply(Complex other) {
        double realProduct = (real * other.real) - (imaginary * other.imaginary);
        double imaginaryProduct = (real * other.imaginary) + (imaginary * other.real);
        return new Complex(realProduct, imaginaryProduct);
    }

    public Complex divide(Complex other) {
        double divisor = (other.real * other.real) + (other.imaginary * other.imaginary);
        double realQuotient = ((real * other.real) + (imaginary * other.imaginary)) / divisor;
        double imaginaryQuotient = ((imaginary * other.real) - (real * other.imaginary)) / divisor;
        return new Complex(realQuotient, imaginaryQuotient);
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class ComplexMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first complex number
        System.out.print("Enter the real part of the first complex number: ");
        double real1 = scanner.nextDouble();
        System.out.print("Enter the imaginary part of the first complex number: ");
        double imaginary1 = scanner.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        System.out.print("Enter the real part of the second complex number: ");
        double real2 = scanner.nextDouble();
        System.out.print("Enter the imaginary part of the second complex number: ");
        double imaginary2 = scanner.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            Complex result;

            switch (choice) {
                case 1:
                    result = complex1.add(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = complex1.subtract(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = complex1.multiply(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = complex1.divide(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
