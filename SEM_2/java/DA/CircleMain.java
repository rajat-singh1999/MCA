class Circle {
    private double radius;

    public Circle() {
        radius = 0.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }
}

public class CircleMain {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Circle 1 - Radius: " + circle1.getRadius());
        System.out.println("Circle 1 - Area: " + circle1.findArea());

        Circle circle2 = new Circle(5.0);
        System.out.println("Circle 2 - Radius: " + circle2.getRadius());
        System.out.println("Circle 2 - Area: " + circle2.findArea());
    }
}
