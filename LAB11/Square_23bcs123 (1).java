// Square Class
class Square_23bcs123 extends Polygon_23bcs123 {

    public Square_23bcs123(List<Point2D_23bcs123> vertices) {
        super(vertices);
    }

    @Override
    public double area() {
        double sideLength = vertices.get(0).calcDistance(vertices.get(1)); 
        return Math.pow(sideLength, 2);
    }

    @Override
    public double perimeter() {
        double sideLength = vertices.get(0).calcDistance(vertices.get(1)); 
        return 4 * sideLength;
    }
}