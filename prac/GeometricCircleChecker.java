import java.util.Random;

class Point2D {
    private int corX, corY;
    public Point2D() { this(0, 0); }
    public Point2D(int corX, int corY) { this.corX = corX; this.corY = corY; }
    public int getX() { return corX; }
    public int getY() { return corY; }
    public double calcDistance(Point2D p) {
        return Math.sqrt(Math.pow(corX - p.getX(), 2) + Math.pow(corY - p.getY(), 2));
    }
}

class Line {
    private Point2D start, end;
    public Line(Point2D start, Point2D end) { this.start = start; this.end = end; }
    public Point2D getStart() { return start; }
    public Point2D getEnd() { return end; }
    public double getSlope() {
        return (end.getX() == start.getX()) ? Double.POSITIVE_INFINITY : (double) (end.getY() - start.getY()) / (end.getX() - start.getX());
    }
    public double getYIntercept() { return start.getY() - getSlope() * start.getX(); }
    public Point2D getIntersectionPoint(Line other) {
        double m1 = getSlope(), m2 = other.getSlope();
        if (m1 == m2) { System.out.println("Lines are parallel, no intersection."); return null; }
        if (Double.isInfinite(m1)) return new Point2D(start.getX(), (int)m2 * start.getX() + (int)other.getYIntercept());
        if (Double.isInfinite(m2)) return new Point2D(other.getStart().getX(), (int)m1 * other.getStart().getX() + (int)getYIntercept());
        double xIntersect = (other.getYIntercept() - getYIntercept()) / (m1 - m2);
        return new Point2D((int) xIntersect, (int) (m1 * xIntersect + getYIntercept()));
    }
    public double length() { return start.calcDistance(end); }
}

class Circle {
    private Point2D center; 
    private int radius;
    public Circle() { this(new Point2D(), 1); }
    public Circle(Point2D center, int radius) { this.center = center; this.radius = radius; }
    public Point2D getCenter() { return center; }
    public int getRadius() { return radius; }
    public double area() { return Math.PI * Math.pow(radius, 2); }
    public boolean isInside(Point2D p) { return center.calcDistance(p) < radius; }
    public boolean intersects(Circle other) {
        return center.calcDistance(other.getCenter()) <= (radius + other.getRadius());
    }
}

public class GeometricCircleChecker {
    public static Point2D getRandomPoint(int maxX, int maxY) {
        return new Point2D(new Random().nextInt(maxX), new Random().nextInt(maxY));
    }
    public static Circle getRandomCircle(int maxX, int maxY, int maxRadius) {
        return new Circle(getRandomPoint(maxX, maxY), new Random().nextInt(maxRadius) + 1);
    }
    public static void main(String[] args) {
        Circle[] circles = new Circle[10];
        for (int i = 0; i < circles.length; i++) circles[i] = getRandomCircle(100, 100, 20);
        
        int intersectingPairs = 0;
        for (int i = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                if (circles[i].intersects(circles[j])) intersectingPairs++;
            }
        }
        System.out.println("Number of intersecting circle pairs: " + intersectingPairs);
        
        System.out.println("Adjusting circles to not intersect...");
        for (int i = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                while (circles[i].intersects(circles[j])) circles[i] = new Circle(getRandomPoint(100, 100), circles[i].getRadius());
            }
        }

        Point2D testPoint = getRandomPoint(100, 100);
        Circle testCircle = circles[0];
        System.out.println("Point (" + testPoint.getX() + ", " + testPoint.getY() + ") is " + 
                           (testCircle.isInside(testPoint) ? "inside" : "outside") + " the circle.");

        Line line1 = new Line(getRandomPoint(100, 100), getRandomPoint(100, 100));
        Line line2 = new Line(getRandomPoint(100, 100), getRandomPoint(100, 100));

        System.out.println("Line 1: (" + line1.getStart().getX() + ", " + line1.getStart().getY() + ") to (" +
                           line1.getEnd().getX() + ", " + line1.getEnd().getY() + ")");
        System.out.println("Line 2: (" + line2.getStart().getX() + ", " + line2.getStart().getY() + ") to (" +
                           line2.getEnd().getX() + ", " + line2.getEnd().getY() + ")");

        Point2D intersection = line1.getIntersectionPoint(line2);
        System.out.println(intersection != null ? "Intersection Point: (" + intersection.getX() + ", " + intersection.getY() + ")" :
                                                   "No intersection point found.");
    }
}
