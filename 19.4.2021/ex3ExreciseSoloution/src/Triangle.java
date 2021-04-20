import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    java.awt.Color color = Color.BLUE;


    public Triangle(Point p1, Point p2, Point p3) {
        vertex1 = p1;
        vertex2 = p2;
        vertex3 = p3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        vertex1 = new Point(x1,y1);
        vertex2 = new Point(x2,y2);
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
        for(Line segment : getSegments()) {
            if(segment.isIntersecting(line)) {
                intersectionPoints.add(segment.intersectionWith(line));
            }
        }
        return intersectionPoints;
    }

    public List<Line> getSegments() {
        List<Line> segments = new ArrayList<>();
        segments.add(new Line(vertex1, vertex2));
        segments.add(new Line(vertex2, vertex3));
        segments.add(new Line(vertex3, vertex1));
        return segments;
    }

    public Line getCollisionSegment(Point collisionPoint) {
            for(Line l : getSegments()) {
                if(l.isPointOnLine(collisionPoint)) {
                    return l;
                }
            }
            return null;
    }

    public void drawOn(DrawSurface d) {
        Polygon p = new Polygon();
        p.addPoint((int) vertex1.getX(),(int) vertex1.getY());
        p.addPoint((int) vertex2.getX(),(int) vertex2.getY());
        p.addPoint((int) vertex3.getX(),(int) vertex3.getY());
        d.drawPolygon(p);
        d.setColor(Color.BLUE);
        d.fillPolygon(p);
    }
}
