import java.util.*;

// Point2D Class
class Point2D_23bcs123 {
    private int x, y;
    public Point2D_23bcs123() { this.x = this.y = 0; }
    public Point2D_23bcs123(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    public double calcDistance(Point2D_23bcs123 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

// Line Class
class Line_23bcs123 {
    private Point2D_23bcs123 start, end;
    public Line_23bcs123(Point2D_23bcs123 start, Point2D_23bcs123 end) { this.start = start; this.end = end; }
    public Point2D_23bcs123 getStart() { return start; }
    public Point2D_23bcs123 getEnd() { return end; }
    public double length() { return start.calcDistance(end); }
}

// Polygon Class
abstract class Polygon_23bcs123 extends Line_23bcs123 {
    protected List<Point2D_23bcs123> vertices;
    public Polygon_23bcs123(List<Point2D_23bcs123> vertices) { super(vertices.get(0), vertices.get(1)); this.vertices = vertices; }
    public double perimeter() {
        double p = 0;
        for (int i = 0; i < vertices.size(); i++)
            p += vertices.get(i).calcDistance(vertices.get((i + 1) % vertices.size()));
        return p;
    }
    public boolean isConvex() {
        int n = vertices.size(); if (n < 3) return false;
        boolean sign = false;
        for (int i = 0; i < n; i++) {
            Point2D_23bcs123 p1 = vertices.get(i), p2 = vertices.get((i + 1) % n), p3 = vertices.get((i + 2) % n);
            double crossProduct = (p2.getX() - p1.getX()) * (p3.getY() - p2.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p2.getX());
            if (i == 0) sign = crossProduct > 0;
            else if (sign != (crossProduct > 0)) return false;
        }
        return true;
    }
    public abstract double area();
}

// Circle Class
class Circle_23bcs123 extends Polygon_23bcs123 {
    private double radius;
    public Circle_23bcs123(Point2D_23bcs123 center, double radius) { super(List.of(center, center)); this.radius = radius; }
    @Override public double area() { return Math.PI * Math.pow(radius, 2); }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
    @Override public boolean isConvex() { return true; }
}

// Square Class
class Square_23bcs123 extends Polygon_23bcs123 {
    public Square_23bcs123(List<Point2D_23bcs123> vertices) { super(vertices); }
    @Override public double area() { return Math.pow(vertices.get(0).calcDistance(vertices.get(1)), 2); }
    @Override public double perimeter() { return 4 * vertices.get(0).calcDistance(vertices.get(1)); }
}

// Rectangle Class
class Rectangle_23bcs123 extends Polygon_23bcs123 {
    public Rectangle_23bcs123(List<Point2D_23bcs123> vertices) { super(vertices); }
    @Override public double area() {
        double length = vertices.get(0).calcDistance(vertices.get(1)), width = vertices.get(1).calcDistance(vertices.get(2));
        return length * width;
    }
    @Override public double perimeter() {
        double length = vertices.get(0).calcDistance(vertices.get(1)), width = vertices.get(1).calcDistance(vertices.get(2));
        return 2 * (length + width);
    }
}

// Main App
public class GeometricShapesApp_23bcs123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to create a circle (y/n)? ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter the x-coordinate of the center: ");
            int centerX = scanner.nextInt();
            System.out.print("Enter the y-coordinate of the center: ");
            int centerY = scanner.nextInt();
            System.out.print("Enter the radius of the circle: ");
            double radius = scanner.nextDouble();
            Circle_23bcs123 circle = new Circle_23bcs123(new Point2D_23bcs123(centerX, centerY), radius);
            System.out.println("Area of the circle: " + circle.area());
            System.out.println("Perimeter (Circumference) of the circle: " + circle.perimeter());
        } else {
            System.out.print("Enter the number of vertices for the polygon: ");
            int numVertices = scanner.nextInt();
            List<Point2D_23bcs123> vertices = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Enter x-coordinate of vertex " + (i + 1) + ": ");
                int x = scanner.nextInt();
                System.out.print("Enter y-coordinate of vertex " + (i + 1) + ": ");
                int y = scanner.nextInt();
                vertices.add(new Point2D_23bcs123(x, y));
            }
            Polygon_23bcs123 polygon;
            if (numVertices == 4) {
                System.out.print("Is it a square (y/n)? ");
                polygon = scanner.next().equalsIgnoreCase("y") ? new Square_23bcs123(vertices) : new Rectangle_23bcs123(vertices);
            } else polygon = new Polygon_23bcs123(vertices) { @Override public double area() { return 0; }};
            System.out.println("Area of the polygon: " + polygon.area());
            System.out.println("Perimeter of the polygon: " + polygon.perimeter());
            System.out.println("Is the polygon convex? " + polygon.isConvex());
        }
        scanner.close();
    }
}
