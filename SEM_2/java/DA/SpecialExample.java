abstract class Special {
    public abstract double process(double P, double R);
}

class Discount extends Special {
    @Override
    public double process(double P, double R) {
        double total = P + (P * R / 100);
        return total;
    }
}

public class SpecialExample {
    public static void main(String[] args) {
        double price = 100.0;
        double rate = 10.0;

        Special special = new Discount();
        double result = special.process(price, rate);
        System.out.println("Total with discount: " + result);
    }
}
