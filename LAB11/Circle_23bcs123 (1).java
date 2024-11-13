// Circle Class
class Circle_23bcs123 extends Polygon_23bcs123 {
    private double radius;

    public Circle_23bcs123(Point2D_23bcs123 center, double radius) {
        super(List.of(center, center));  
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isConvex() {
        return true; 
    }
}