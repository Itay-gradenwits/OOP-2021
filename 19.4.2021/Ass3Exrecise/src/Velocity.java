/**
 * @author Itay Gradenwits 213713522.
 */
public class Velocity {
    private static double epsilon = Math.pow(10, -14);
    private double dx;
    private double dy;

    // constructor

    /**
     * @param dx is a value to define as the dx of the velocity.
     * @param dy is a value to define as the xy of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    //accessors

    /**
     * getDx -- Return the dx of this velocity.
     *
     * @return the dx of this velocity.
     */
    public double getDx() {
        return dx;
    }

    /**
     * getDy -- Return the dy of this velocity.
     *
     * @return the dy of this velocity.
     */
    public double getDy() {
        return dy;
    }

    /**
     * equals -- check if other velocity is equal to this.
     * @param v the other velocity.
     * @return true if the dx and dy is identity and false otherWise.
     */
    public boolean equals(Velocity v) {
        return (Math.abs(this.getDx() - v.getDx()) <= epsilon) && (Math.abs(this.getDy() - v.getDy()) <= epsilon);
    }

    /**
     * applyToPoint -- Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the point to apply this velocity on.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.getDx(), p.getY() + this.getDy());
    }

    /**
     * reset -- reset the fields of this Velocity with a new values.
     *
     * @param newDx a value to define as the dx of this velocity.
     * @param newDy a valuew to define as the dy of this velocity.
     */
    void set(double newDx, double newDy) {
        this.dx = newDx;
        this.dy = newDy;
    }

    /**
     * set -- set the fields of this Velocity with a new values.
     *
     * @param newVelocity is a new Velocity that holds a values to define as the fields of this velocity.
     */
    void set(Velocity newVelocity) {
        this.set(newVelocity.getDx(), newVelocity.getDy());
    }

    /**
     * resetDx -- reset the dx field.
     *
     * @param newDx a value to define as the dx of this velocity.
     */
    void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * resetDy -- reset the dy field.
     *
     * @param newDy a value to define as the dy of this velocity.
     */
    void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * fromAngleAndSpees -- create a new velocity and define its fields using angle and spped.
     *
     * @param angle the way the velocity work (we define 90 degrees as up)
     * @param speed the size of the velocity
     * @return a Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //using trigonometry.
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = -speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * getSpeed -- return the speed of the velocity using math formula.
     * @return the speed of the velocity using math formula.
     */
    public double getSpeed() {
        //using pitagoras sentences.
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }


    /**
     * getSpeed -- return the angle of the velocity using trigonometry.
     * @return the angle of the velocity using trigonometry.
     */
    public double getAngle() {
        //using trigonometry.
        return Math.toDegrees(Math.atan(-dy / dx));
    }
}
