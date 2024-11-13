// Rectangle Class
class Rectangle_23bcs123 extends Polygon_23bcs123 {

    public Rectangle_23bcs123(List<Point2D_23bcs123> vertices) {
        super(vertices);
    }

    @Override
    public double area() {
        double length = vertices.get(0).calcDistance(vertices.get(1));
        double width = vertices.get(1).calcDistance(vertices.get(2));
        return length * width;
    }

    @Override
    public double perimeter() {
        double length = vertices.get(0).calcDistance(vertices.get(1));
        double width = vertices.get(1).calcDistance(vertices.get(2));
        return 2 * (length + width);
    }
}
