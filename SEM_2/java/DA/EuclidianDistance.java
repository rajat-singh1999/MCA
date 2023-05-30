import java.lang.Math;

class Line {
    private double x1, y1;  // First point
    private double x2, y2;  // Second point

    public Line() {
        x1 = y1 = x2 = y2 = 0.0;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double computeLength() {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }
}

public class EuclidianDistance {
    public static void main(String[] args) {
        Line line1 = new Line();
        System.out.println("Line 1 Length: " + line1.computeLength());

        Line line2 = new Line(1.0, 2.0, 4.0, 6.0);
        System.out.println("Line 2 Length: " + line2.computeLength());
    }
}
