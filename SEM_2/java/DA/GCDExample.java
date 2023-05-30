interface GCD {
    int computeGCD(int num1, int num2);
}

class APPROACH1 implements GCD {
    @Override
    public int computeGCD(int num1, int num2) {
        // Implementing Euclid's algorithm to compute GCD
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}

class APPROACH2 implements GCD {
    @Override
    public int computeGCD(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

public class GCDExample {
    public static void main(String[] args) {
        int number1 = 36;
        int number2 = 48;

        // Using APPROACH1 (Euclid's algorithm) to compute GCD
        GCD approach1 = new APPROACH1();
        int gcd1 = approach1.computeGCD(number1, number2);
        System.out.println("GCD using APPROACH1: " + gcd1);

        // Using APPROACH2 (listing factors) to compute GCD
        GCD approach2 = new APPROACH2();
        int gcd2 = approach2.computeGCD(number1, number2);
        System.out.println("GCD using APPROACH2: " + gcd2);
    }
}
