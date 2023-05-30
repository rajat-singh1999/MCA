import pack1.Arithmetic;
import pack2.Calculator;

public class PackageTesting2 implements Arithmetic, Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        PackageTesting2 obj = new PackageTesting2();
        int num1 = 10;
        int num2 = 5;

        System.out.println("Addition: " + obj.add(num1, num2));
        System.out.println("Subtraction: " + obj.sub(num1, num2));
        System.out.println("Multiplication: " + obj.multiply(num1, num2));
        System.out.println("Division: " + obj.divide(num1, num2));
    }
}