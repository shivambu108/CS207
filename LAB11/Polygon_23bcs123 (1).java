// Polygon Class
abstract class Polygon_23bcs123 extends Line_23bcs123 {
    protected List<Point2D_23bcs123> vertices;

    public Polygon_23bcs123(List<Point2D_23bcs123> vertices) {
        super(vertices.get(0), vertices.get(1)); 
        this.vertices = vertices;
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.size(); i++) {
            int nextIndex = (i + 1) % vertices.size(); 
            perimeter += vertices.get(i).calcDistance(vertices.get(nextIndex));
        }
        return perimeter;
    }

    public boolean isConvex() {
        int n = vertices.size();
        if (n < 3) return false; 
        boolean sign = false;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            int nextNext = (i + 2) % n;

            Point2D_23bcs123 p1 = vertices.get(i);
            Point2D_23bcs123 p2 = vertices.get(next);
            Point2D_23bcs123 p3 = vertices.get(nextNext);

            double crossProduct = (p2.getX() - p1.getX()) * (p3.getY() - p2.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p2.getX());
            if (i == 0) {
                sign = crossProduct > 0;
            } else {
                if (sign != (crossProduct > 0)) {
                    return false; 
                }
            }
        }
        return true;
    }

    public abstract double area();
}

