import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructors.
     *
     * @param start the point we want to define as the start point of the line.
     * @param end   the point we want to define as the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    /**
     * @param x1 the x value of the point we want to define as the start point of the line.
     * @param y1 the y value of the point we want to define as the start point of the line.
     * @param x2 the x value of the point we want to define as the end point of the line.
     * @param y2 the y value of the point we want to define as the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length of the line witch is the distance between the end point and the start point of the line.
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     * Middle point.
     *
     * @return the middle point of the line using math formula.
     */
    public Point middle() {
        return (new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2));
    }

    /**
     * Returns the start point of the line.
     *
     * @return the start point of the line
     */
    public Point start() {
        return new Point(this.start.getX(), this.start.getY());
    }

    /**
     * Returns the end point of the line.
     *
     * @return the end point of the line
     */
    public Point end() {
        return new Point(this.end.getX(), this.end.getY());
    }

    /**
     * set -- set this ball with new fields.
     *
     * @param newStart is a point to define as the  new start point of the line.
     * @param newEnd   is a point to define as the new end point of the line.
     */
    public void set(Point newStart, Point newEnd) {
        this.start.set(newStart.getX(), newStart.getY());
        this.end.set(newEnd.getX(), newEnd.getY());
    }

    /**
     * Incline of a line.
     *
     * @return the incline of the line using the function from  the Point Class.
     */
    public Double incline() {
        return this.start.incline(this.end);
    }

    /**
     * intersectWithY of a line.
     *
     * @return the y value of the intersection point of the line with the y axis - using math formulas.
     */
    public Double intersectWithY() {
        if (this.start.getX() == this.end.getX()) {
            return null;
        }
        return this.start.getY() - this.incline() * this.start.getX();
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other is a line to check if it intersect with this line
     * @return true if the intersection point exist (using the next function) and false if not.
     */
    // Returns true if the lines intersect, false otherwise

    //look for the intersection point ,if it exist return true, else false.
    public boolean isIntersecting(Line other) {
        return (this.intersectionWith(other) != null);
    }

    /**
     * intersectionWith.
     * Returns the intersection point if the lines intersect, and null otherwise.
     * using division into cases about the incline of the lines and math formulas that dit to the certain case.
     *
     * @param other is a line to find the intersection point with this line (if it exist).
     * @return the intersection point if it exist and null if not.
     */
    public Point intersectionWith(Line other) {
        if (other == null) {
            throw new RuntimeException("the other line is not initialized");
        }
        // if both of the line doesn't have incline.
        if (other.incline() == null && this.incline() == null) {

            // it the lines continue each other
            if (this.start.equals(other.end) || this.start.equals(other.start)) {
                return this.start;
            }
            if (this.end.equals(other.end) || this.end.equals(other.start)) {
                return this.end;
            }
            return null;
        }
        //if both of the lines have incline.
        if (((this.incline()) != null) && (other.incline() != null)) {
            // if the inclines are the same.
            if (other.incline().equals(this.incline())) {

                //it the lines continue each other.
                if (this.start.equals(other.end) || this.start.equals(other.start)) {
                    return this.start;
                }
                if (this.end.equals(other.end) || this.end.equals(other.start)) {
                    return this.end;
                }
                //if we didnt find an intersection point.
                return null;

            } else {
                //if the linesdoesnt have the same incline/

                //use math formula to find the intersection point
                double xValue = (other.intersectWithY() - this.intersectWithY()) / (this.incline() - other.incline());
                double yValue = this.incline() * xValue + this.intersectWithY();
                //make sure the point is really on the lines and not at the rest of them.
                return checkIfPointIsOnLinesAndReturnIt(new Point(xValue, yValue), this, other);
            }
        }
        //if one of the line has incline and the other not.
        if (other.incline() == null) {
            //use math formula to find the intersection point
            double xValue = other.start.getX();
            double yValue = this.incline() * xValue + this.intersectWithY();
            //make sure the point is really on the lines and not at the rest of them.
            return checkIfPointIsOnLinesAndReturnIt(new Point(xValue, yValue), this, other);
        }

        //if one of the line has incline and the other not(case 2).

        //use math formula to find the intersection point
        double xValue = this.start.getX();
        double yValue = other.incline() * xValue + other.intersectWithY();
        //make sure the point is really on the lines and not at the rest of them.
        return checkIfPointIsOnLinesAndReturnIt(new Point(xValue, yValue), this, other);
    }

    /**
     * return the point we got as argument if it is on both of the lines and null if it is on the continue one of them.
     *
     * @param point is a point to check if it's on the lines.
     * @param line1 is of the lines we mention above.
     * @param line2 is one the lines we mention above.
     * @return the point we got as argument or null.
     */
    static Point checkIfPointIsOnLinesAndReturnIt(Point point, Line line1, Line line2) {
        //if the point is on both of the return it otherWise return false
        if (line1.isPointOnLine(point) && line2.isPointOnLine(point)) {
            return point;
        }
        return null;
    }

    /**
     * return true if the point is on this line and false if it is on the continue of the line.
     *
     * @param point is a point to check if it's on the line.
     * @return true or false, using function from Point Class.
     */
    public boolean isPointOnLine(Point point) {
        return point.isPointBetween2Points(this.start, this.end);
    }

    /**
     * equals -- return true if the lines are equal, false otherwise.
     *
     * @param other the line to check if equal to this line.
     *              equal means that the start points and the end points of the lines are equal.
     * @return true or false, using function "equal" from Class Point.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * generateRandomLine -- Return random line that its points have int fields in certain range.
     *
     * @param leftEdge  is the min x value that the point of the line can have
     * @param rightEdge is the max x value that the point of the line can have
     * @param lowerEdge is the min y value that the point of the line can have
     * @param upperEdge is the max y value that the point of the line can have
     * @return a random line in the plesent range.
     */
    public static Line generateRandomLine(int leftEdge, int rightEdge, int lowerEdge, int upperEdge) {
        Point start = Point.generateRandomPointInRange(leftEdge, rightEdge, lowerEdge, upperEdge);
        Point end = Point.generateRandomPointInRange(leftEdge, rightEdge, lowerEdge, upperEdge);
        return new Line(start, end);
    }

    /**
     * drawOn -- to draw this line.
     *
     * @param d     a DrawSurface to draw the line on.
     * @param color a color for the line.
     */
    public void drawOn(DrawSurface d, java.awt.Color color) {
        d.setColor(color);
        int x1 = (int) this.start().getX();
        int x2 = (int) this.start().getY();
        int x3 = (int) this.end().getX();
        int x4 = (int) this.end().getY();
        d.drawLine(x1, x2, x3, x4);
    }

    /**
     * drawLine.
     *
     * @param line to draw.
     * @param d    a DrawSurFace to draw the line on.
     */
    public static void drawLine(Line line, DrawSurface d) {
        d.setColor(Color.BLACK);
        int x1 = (int) line.start().getX();
        int y1 = (int) line.start().getY();
        int x2 = (int) line.end().getX();
        int y2 = (int) line.end().getY();
        d.drawLine(x1, y1, x2, y2);
    }

    /**
     * closestIntersectionToStartOfLine -- If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect is the rectangle we mention above.
     * @return the closest intersection point to the start point of the line.
     */
//    public Point closestIntersectionToStartOfLine(Rectangle rect) {
//        if (rect == null) {
//            throw new RuntimeException();
//        }
//        //the closest intersection point of line with a rectangle is the closest point from the rectangle's
//        //intersection points list
//        return this.closestPointToStartFromAList(rect.intersectionPoints(this));
//    }

    /**
     * closestPointToStartFromAList -- return the colsest point to the start point of the line from the points in an
     * input list.
     *
     * @param pointsList is the points list.
     * @return the closest point to start of the line from the list above.
     */
    public Point closestPointToStartFromAList(List<Point> pointsList) {
        if (pointsList == null) {
            throw new RuntimeException("The list is not initialized");
        }
        if (pointsList.isEmpty()) {
            return null;
        }

        //define the first point in the list to be the closest.
        Point closestPoint = new Point(pointsList.get(0).getX(), pointsList.get(0).getY());
        double minDistance = this.start.distance(closestPoint);
        for (Point point : pointsList) {
            //every time we find a closer point, change the closest point to be it
            if (this.start.distance(point) < minDistance) {
                closestPoint.set(point.getX(), point.getY());
                minDistance = this.start.distance(point);
            }
        }
        return closestPoint;
    }

    /**
     * print a line in this format, start: (x1,y1) end: (x2,y2).
     */
    public void print() {
        System.out.println("start: ( + " + this.start.getX() + "," + this.start.getY() + ")" + " end: ( + "
                + this.end.getX() + "," + this.end.getY() + ")");
    }


    //lesson
    public Point closestIntersectionToStartOfLineTriangle(Triangle triangle) {
        if(triangle.intersectionPoints(this).isEmpty()) {
            return null;
        }
        List<Point> intersectionPoints = triangle.intersectionPoints(this);
        double min = intersectionPoints.get(0).distance(this.start);
        Point closestPoint = intersectionPoints.get(0);

        for(Point p : triangle.intersectionPoints(this)) {
            if(p.distance(this.start) < min) {
                min = p.distance(this.start);
                closestPoint = p;
            }
        }
        return closestPoint;
    }
}