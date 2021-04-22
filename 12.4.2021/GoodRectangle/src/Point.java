import java.util.Random;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Point {
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
        return (this.y - other.y) / (this.x - other.x);
    }

    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other a point to check if identity to this point.
     * @return :true if the x and y values of the 2 points are equals.
     */
    public boolean equals(Point other) {
        return ((this.x == other.x) && (this.y == other.y));
    }

    // Return the x and y values of this point:

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
        return ((point1.x <= this.x && this.x <= point2.x) || (point2.x <= this.x && this.x <= point1.x));
    }

    /**
     * check if the y value of this point is between 2 the y values of 2 points.
     *
     * @param point1 point 1
     * @param point2 point2
     * @return true or false according to the y values.
     */
    public boolean isYOfPointsBetween2YOfPoints(Point point1, Point point2) {
        return ((point1.y <= this.y && this.y <= point2.y) || (point2.y <= this.y && this.y <= point1.y));
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
     * @param leftEdge is the min x value that the point can has.
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
     * reset -- reset the fields of this point.
     * @param newX the new x value.
     * @param newY the new y value.
     */
    public void reset(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
}