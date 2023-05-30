class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Quadrilateral {
    public Point point1;
    public Point point2;
    public Point point3;
    public Point point4;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    // Calculate the area of a Quadrilateral
    public double calculateArea() {
        // The area of a general quadrilateral cannot be determined without specific shape information
        // Return 0.0 or throw an exception to indicate that the calculation is not applicable
        return 0.0;
    }
}

class Trapezoid extends Quadrilateral {
    public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    // Implement the area calculation method for Trapezoid
    public double calculateArea() {
        // Area calculation logic for Trapezoid
        double base1 = Math.abs(point1.getX() - point2.getX());
        double base2 = Math.abs(point3.getX() - point4.getX());
        double height = Math.abs(point2.getY() - point4.getY());
        return (base1 + base2) * height / 2;
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    // Implement the area calculation method for Parallelogram
    public double calculateArea() {
        // Area calculation logic for Parallelogram
        double base = Math.abs(point1.getX() - point2.getX());
        double height = Math.abs(point2.getY() - point4.getY());
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    // Implement the area calculation method for Rectangle
    public double calculateArea() {
        // Area calculation logic for Rectangle
        double width = Math.abs(point1.getX() - point2.getX());
        double height = Math.abs(point2.getY() - point4.getY());
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    // Implement the area calculation method for Square
    public double calculateArea() {
        // Area calculation logic for Square
        double side = Math.abs(point1.getX() - point2.getX());
        return side * side;
    }
}

public class ShapesDemo {
    public static void main(String[] args) {
        // Create objects and calculate areas
        Point point1 = new Point(24, 33);
        Point point2 = new Point(12, 14);
        Point point3 = new Point(15, 20);
        Point point4 = new Point(10, 18);

        Quadrilateral quadrilateral = new Quadrilateral(point1, point2, point3, point4);
        double quadrilateralArea = quadrilateral.calculateArea();
        System.out.println("Quadrilateral Area: " + quadrilateralArea);

        Trapezoid trapezoid = new Trapezoid(point1, point2, point3, point4);
        double trapezoidArea = trapezoid.calculateArea();
        System.out.println("Trapezoid Area: " + trapezoidArea);

        Parallelogram parallelogram = new Parallelogram(point1, point2, point3, point4);
        double parallelogramArea = parallelogram.calculateArea();
        System.out.println("Parallelogram Area: " + parallelogramArea);

        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
        double rectangleArea = rectangle.calculateArea();
        System.out.println("Rectangle Area: " + rectangleArea);

        Square square = new Square(point1, point2, point3, point4);
        double squareArea = square.calculateArea();
        System.out.println("Square Area: " + squareArea);
    }
}
