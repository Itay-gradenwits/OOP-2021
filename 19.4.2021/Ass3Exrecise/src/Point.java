import java.util.List;
import java.util.Random;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Point {
    private static double epsilon = Math.pow(10, -6);
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x a double to enter to the x value of the point.
     * @param y a double to enter to the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance -- return the distance of this point to the other point.
     *
     * @param other the point we want to calculate its distance form this point .
     * @return the distance between those 2 points :using the math formula of distance between 2 points.
     */
    public double distance(Point other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
    }

    /**
     * incline -- return the incline of the line that this point and the other point is on.
     *
     * @param other the point that create with this point the line that we want to calculate its incline.
     * @return the incline ot the line that those 2 points created- using the math formula of incline of a line.
     */
    public Double incline(Point other) {
        if (this.x == other.x) {
            return null;
        }
        //using math formula.
        return (this.y - other.y) / (this.x - other.x);
    }

    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other a point to check if identity to this point.
     * @return :true if the x and y values of the 2 points are equals.
     */
    public boolean equals(Point other) {
        //using epsilon language to compare 2 doubles.
        return ((Math.abs(this.getX() - other.getX()) <= epsilon) && (Math.abs(this.getY() - other.getY()) <= epsilon));
    }

    /**
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * check if the x value of this point is between 2 the x values of 2 points.
     *
     * @param point1 point 1
     * @param point2 point2
     * @return true or false according to the x values.
     */
    public boolean isXOfPointBetween2XOfPoints(Point point1, Point point2) {
        //using epsilon language to compare doubles in order to avoid mistakes.
        return (((point1.getX() < this.getX()) || (Math.abs(this.getX() - point1.getX()) <= epsilon))
                && ((this.getX() < point2.getX()) || (Math.abs(this.getX() - point2.getX()) <= epsilon)))
                || (((point2.getX() < this.getX()) || (Math.abs(this.getX() - point2.getX()) <= epsilon))
                && ((this.getX() < point1.getX()) || (Math.abs(this.getX() - point1.getX()) <= epsilon)));
    }

    /**
     * check if the y value of this point is between 2 the y values of 2 points.
     *
     * @param point1 point 1
     * @param point2 point2
     * @return true or false according to the y values.
     */
    public boolean isYOfPointsBetween2YOfPoints(Point point1, Point point2) {
        //using epsilon language to compare doubles in order to avoid mistakes.
        return (((point1.getY() < this.getY()) || (Math.abs(this.getY() - point1.getY()) <= epsilon))
                && ((this.getY() < point2.getY()) || (Math.abs(this.getY() - point2.getY()) <= epsilon)))
                || (((point2.getY() < this.getY()) || (Math.abs(this.getY() - point2.getY()) <= epsilon))
                && ((this.getY() < point1.getY()) || (Math.abs(this.getY() - point1.getY()) <= epsilon)));
    }

    /**
     * check if a point is between 2 points.
     * (the point is between those 2 points if the x value and the y value of this point are between the x & y values of
     * those 2 points)
     *
     * @param point1 point 1
     * @param point2 point2
     * @return true or false: using the 2 functions above.
     */
    public boolean isPointBetween2Points(Point point1, Point point2) {
        return (isYOfPointsBetween2YOfPoints(point1, point2) && isXOfPointBetween2XOfPoints(point1, point2));
    }

    /**
     * generateRandomPoint -- Return random point that has int fields in certain range.
     *
     * @param leftEdge  is the min x value that the point can has.
     * @param rightEdge is the max x value tht the point can has.
     * @param lowerEdge is the min y value that the point can has.
     * @param upperEdge is the max y value that the point can has.
     * @return a random point in the plesent range.
     */
    public static Point generateRandomPointInRange(int leftEdge, int rightEdge, int lowerEdge, int upperEdge) {
        Random rand = new Random();
        double xValue = rand.nextInt(rightEdge - leftEdge) + leftEdge;
        double yValue = rand.nextInt(upperEdge - lowerEdge) + lowerEdge;
        return new Point(xValue, yValue);
    }

    /**
     * set -- set the fields of this point.
     *
     * @param newX the new x value.
     * @param newY the new y value.
     */
    public void set(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * set -- set the fields of the point.
     *
     * @param newPoint is a Point that holds a field to set as the new fields of the point.
     */
    public void set(Point newPoint) {
        this.x = newPoint.getX();
        this.y = newPoint.getY();
    }

    /**
     * print -- print the point (x,y) in this form: (x,y).
     */
    public void print() {
        System.out.println("(" + this.getX() + "," + this.getY() + ")");
    }


    /**
     * findGoodMovePoint -- by given an intersection point we find a new point that is on the line that represent
     * a movement from this point to the intersection point and that its distance from
     * the intersection point is less that 1.
     *
     * @param intersectionPoint the mention intersection point above.
     * @return the good point mention above.
     */
    public Point findGoodMovePoint(Point intersectionPoint) {
        //look for a closer point to the intersection point than this point, using recursion.
        if (intersectionPoint.distance(new Line(this, intersectionPoint).middle()) <= 1) {
            return new Line(this, intersectionPoint).middle();
        }
        return new Line(this, intersectionPoint).middle().findGoodMovePoint(intersectionPoint);
    }
}