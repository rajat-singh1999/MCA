import pack1.Summation;
import pack1.Difference;
import pack1.subpack1.Product;
import pack1.subpack1.Quotient;
import java.util.Scanner;

public class PackageTesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int sum = Summation.calculate(num1, num2);
        int difference = Difference.calculate(num1, num2);
        int product = Product.calculate(num1, num2);
        double quotient = Quotient.calculate(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        scanner.close();
    }
}
