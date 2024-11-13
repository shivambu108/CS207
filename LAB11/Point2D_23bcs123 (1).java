// Point2D Class
class Point2D_23bcs123 {
    private int x, y;

    public Point2D_23bcs123() {
        this.x = 0;
        this.y = 0;
    }
    public Point2D_23bcs123(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public double calcDistance(Point2D_23bcs123 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}