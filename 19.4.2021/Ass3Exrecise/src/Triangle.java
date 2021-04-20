import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;

    public Triangle(Point v1, Point v2, Point v3) {
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
    }
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        vertex1 = new Point(x1,y1);
        vertex2 = new Point(x2, y2);
        vertex3 = new Point(x3,y3);
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

    public List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        for(Line l : getSegments()) {
            if(l.isIntersecting(line)) {
                intersectionPoints.add(l.intersectionWith(line));
            }
        }
        return intersectionPoints;
    }

    public List<Line> getSegments() {
        List<Line> segments = new ArrayList<>();
        segments.add(new Line(vertex1,vertex2));
        segments.add(new Line(vertex2,vertex3));
        segments.add(new Line(vertex3,vertex1));
        return segments;
    }

    boolean isOnSegment(Point p) {
        for(Line l : getSegments()) {
            if(l.isPointOnLine(p)) {
                return true;
            }
        }
        return false;
    }
}
