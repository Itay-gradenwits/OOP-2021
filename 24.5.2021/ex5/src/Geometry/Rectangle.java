package Geometry;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Rectangle {
    private static double epsilon = Math.pow(10, -14);
    private Point upperLeft;
    private double width;
    private double height;
    private java.awt.Color color;

    /**
     * Constructor.
     *
     * @param upperLeft a point to define as the left and upper point of the rectangle.
     * @param width     a value to define as the width of the rectangle.
     * @param height    a value to define as the height of the rectangle.
     * @param color     a color to define as the color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, java.awt.Color color) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Constructor.
     *
     * @param x      is a value to define as the x value of the left and upper point of the rectangle
     * @param y      is a value to define as the y value of the left and upper point of the rectangle
     * @param width  is a value to define as the width of the rectangle.
     * @param height is a value to define as the height of the rectangle.
     * @param color  is a color to define as the color of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height, java.awt.Color color) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * getWidth.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getUpperLeft.
     *
     * @return the left anf upper point of the rectangle.
     */
    public Point getUpperLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY());
    }

    /**
     * getColor -- return the color of the rectangle.
     * @return the color of the rectangle.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * equals -- check if this rectangle is equals to other.
     *
     * @param rect the other rectangle.
     * @return true if they are equal and false other wisw
     */
    public boolean equals(Rectangle rect) {
        if (rect == null) {
            throw new RuntimeException();
        }
        return this.upperLeft.equals(rect.upperLeft) && (Math.abs(this.width - rect.width) <= epsilon)
                && (Math.abs(this.height - rect.height) <= epsilon);
    }

    /**
     * reset -- set the fields of the rectangle.
     *
     * @param newUpperLeft is a point to define as the left and upper point of the rectangle.
     * @param newWidth     is a value to define as the width of the rectangle.
     * @param newHeight    is a value to define as the height of the rectangle.
     * @param newColor     is a color to define as the color of the rectangle.
     */
    public void set(Point newUpperLeft, double newWidth, double newHeight, Color newColor) {
        this.upperLeft.set(newUpperLeft.getX(), newUpperLeft.getY());
        this.width = newWidth;
        this.height = newHeight;
        this.color = newColor;
    }

    /**
     * reset -- set the fields of the rectangle.
     *
     * @param newX      is a value to define as the x value of the left and upper point of the rectangle
     * @param newY      is a value to define as the y value of the left and upper point of the rectangle
     * @param newWidth  is a value to define as the width of the rectangle.
     * @param newHeight is a value to define as the height of the rectangle.
     * @param newColor  is a color to define as the color of the rectangle.
     */
    public void set(double newX, double newY, double newWidth, double newHeight, Color newColor) {
        this.upperLeft.set(newX, newY);
        this.width = newWidth;
        this.height = newHeight;
        this.color = newColor;
    }

    /**
     * drawOn -- draw the rectangle on a DrawSurface.
     *
     * @param surface a DrawSurFace
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int xValue = (int) this.upperLeft.getX();
        int yValue = (int) this.upperLeft.getY();
        surface.fillRectangle(xValue, yValue, (int) this.width, (int) this.height);
        for (Line line : this.segments()) {
            line.drawOn(surface, Color.BLACK);
        }
    }

    /**
     * segments -- Return a list of the segments of the rectangle as lines.
     *
     * @return a list of the segments of the rectangle as lines.
     */
    public List<Line> segments() {
        if (this.upperLeft == null) {
            throw new RuntimeException();
        }
        // make a line list
        List<Line> segmentsList = new ArrayList<Line>();
        //make a lines that describe te rectangle segments.
        Line line1 = new Line(upperLeft, new Point(upperLeft.getX() + getWidth(), upperLeft.getY()));
        Line line2 = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + getHeight()));
        Line line3 = new Line(upperLeft.getX(), upperLeft.getY() + getHeight(), upperLeft.getX() + width,
                upperLeft.getY() + getHeight());

        Line line4 = new Line(upperLeft.getX() + getWidth(), upperLeft.getY(),
                upperLeft.getX() + getWidth(), upperLeft.getY() + getHeight());

        //add them to the list.
        segmentsList.add(line1);
        segmentsList.add(line2);
        segmentsList.add(line3);
        segmentsList.add(line4);
        return segmentsList;
    }

    /**
     * widthSegments -- Return a list of the width segments od the rectangle as lines.
     *
     * @return a list of the width segments od the rectangle as lines.
     */
    public List<Line> widthSegments() {
        if (this.upperLeft == null) {
            throw new RuntimeException();
        }
        //create a lines list.
        List<Line> widthSegmentsList = new ArrayList<Line>();

        //create a lines that describe the width segments ot the rectangle
        Line line1 = new Line(upperLeft, new Point(upperLeft.getX() + getWidth(), upperLeft.getY()));

        Line line2 = new Line(upperLeft.getX(), upperLeft.getY() + getHeight(), upperLeft.getX() + getWidth(),
                upperLeft.getY() + getHeight());

        //add them to the list.
        widthSegmentsList.add(line1);
        widthSegmentsList.add(line2);
        return widthSegmentsList;
    }

    /**
     * heightSegments -- Return a list of the height segments od the rectangle as lines.
     *
     * @return a list of the width segments od the rectangle as lines.
     */
    public List<Line> heightSegments() {
        if (this.upperLeft == null) {
            throw new RuntimeException();
        }
        //create a lines list.
        List<Line> heightSegmentsList = new ArrayList<Line>();

        //create a lines that describe the height segments ot the rectangle
        Line line1 = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + getHeight()));
        Line line2 = new Line(upperLeft.getX() + getWidth(), upperLeft.getY(), upperLeft.getX() + getWidth(),
                upperLeft.getY() + getHeight());

        //add them to the list.
        heightSegmentsList.add(line1);
        heightSegmentsList.add(line2);
        return heightSegmentsList;
    }

    /**
     * isPointOnWidthSegments -- Check if a point is on one of the width segments of the rectangle.
     *
     * @param point is a point to check if it on one of the rectangle width segments.
     * @return true if the point is on one of the rectangle width lines and false if not.
     */
    public boolean isPointOnWidthSegments(Point point) {
        if (point == null) {
            throw new RuntimeException("the point is not initialized");
        }
        if (this.upperLeft == null) {
            throw new RuntimeException("the upperLeft point is not initialized");
        }
        //run all over the width segments of the rectangle and check if the point is on one of them.
        for (Line line : this.widthSegments()) {
            if (line.isPointOnLine(point)) {
                return true;
            }
        }
        return false;
    }

    /**
     * isPointOnHeightSegments -- Check if a point is on one of the height segments of the rectangle.
     *
     * @param point is a point to check if it on one of the rectangle height segments.
     * @return true if the point is on one of the rectangle height lines and false if not.
     */
    public boolean isPointOnHeightSegments(Point point) {
        if (point == null) {
            throw new RuntimeException("the point is not initialized");
        }
        if (this.upperLeft == null) {
            throw new RuntimeException("the upperLeft point is not initialized");
        }

        //run all over the height segments of the rectangle and check if the point is on one of them.
        for (Line line : this.heightSegments()) {
            if (line.isPointOnLine(point)) {
                return true;
            }
        }
        return false;
    }

    /**
     * intersectionPoints -- Return a (possibly empty) List of intersection points of the rectangle with an input line.
     *
     * @param line is the mentioned line.
     * @return a (possibly empty) List of intersection points of the rectangle with the line above.
     */
    public List<Point> intersectionPoints(Line line) {
        if (line == null) {
            throw new RuntimeException();
        }
        //create a points list.
        List<Point> intersectionPointsList = new ArrayList<Point>();

        //run all over the segments lines of the rectangle.
        for (Line other : this.segments()) {
            //if the line and the segments intersct:
            if (line.isIntersecting(other)) {
                //add the intersection point to the list.
                intersectionPointsList.add(line.intersectionWith(other));
            }
        }
        return intersectionPointsList;
    }
}
