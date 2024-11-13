// Line Class
class Line_23bcs123 {
    private Point2D_23bcs123 start, end;

    public Line_23bcs123(Point2D_23bcs123 start, Point2D_23bcs123 end) {
        this.start = start;
        this.end = end;
    }

    public Point2D_23bcs123 getStart() {return start;}
    public Point2D_23bcs123 getEnd() {return end;}
    public double length() {return start.calcDistance(end);}
}
