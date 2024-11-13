import java.util.*;

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
                String isSquare_23bcs123 = scanner.next();
                if (isSquare_23bcs123.equalsIgnoreCase("y")) {
                    polygon = new Square_23bcs123(vertices);
                } else {
                    polygon = new Rectangle_23bcs123(vertices);
                }
            } else {
                polygon = new Polygon_23bcs123(vertices) {
                    @Override
                    public double area() {
                        return 0; 
                    }
                };
            }

            System.out.println("Area of the polygon: " + polygon.area());
            System.out.println("Perimeter of the polygon: " + polygon.perimeter());
            System.out.println("Is the polygon convex? " + polygon.isConvex());
        }
        scanner.close();
    }
}