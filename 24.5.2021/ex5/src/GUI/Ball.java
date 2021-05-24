package GUI;

import GUI.Collision.GameEnvironment;
import Geometry.Line;
import Geometry.Point;
import Movement.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Ball implements Sprite {
    private static double epsilon = Math.pow(10, -14);
    private static final double C = 20;
    private static final int RIGHT = 1;
    private static final int LEFT = 2;
    private static final int NONE = 3;
    private static final int UP = 4;
    private static final int DOWN = 5;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;


    //Constructors//

    /**
     * @param gameEnvironment is a game environment to define as the game environment of the ball.
     * @param center          is the point to define as the center of the circle.
     * @param r               is a number to define as the radius of the circle.
     * @param color           is a color to define as the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.velocity = null;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * @param center is the point to define as the center of the circle.
     * @param r      is a number to define as the radius of the circle.
     * @param color  is a color to define as the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.velocity = null;
        this.gameEnvironment = null;
    }

    /**
     * @param x     is a value to define as the x value of the point.
     * @param y     is a value to define as the y value of the point.
     * @param r     is a number to define as the radius of the circle.
     * @param color is a color to define as the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = null;
    }

    /**
     * equals -- Return true if the circles are identity and false otherwise.
     *
     * @param other is an other circle to compare.
     * @return true or false.
     */
    public boolean equals(Ball other) {
        return this.center.equals(other.center) && (this.r == other.r) && (this.color.equals(other.color));
    }

    // accessors

    /**
     * getX -- return the x value of the center point of the ball.
     *
     * @return the x value of the center point of the ball.
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * getX -- return the x value of the center point of the ball.
     *
     * @return the x value of the center point of the ball.
     */
    public double getY() {
        return (this.center.getY());
    }

    /**
     * getCenter -- return the center point of the ball.
     *
     * @return the center point of the ball.
     */
    public Point getCenter() {
        return new Point(this.getX(), this.getY());
    }

    /**
     * getSize -- return the radius of the ball.
     *
     * @return return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * getColor -- return the color of the ball.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * getVelocity -- return the velocity of the ball.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return new Velocity(this.velocity.getDx(), this.velocity.getDy());
    }

    /**
     * set -- set the fields of this ball with new fields.
     *
     * @param newCenter a new point to define as the center of the ball.
     * @param newR      a new radius to define as the center of the ball.
     * @param newColor  a new color to define as the color of the ball.
     */
    public void set(Point newCenter, int newR, java.awt.Color newColor) {
        this.center.set(newCenter.getX(), newCenter.getY());
        this.r = newR;
        this.color = newColor;
    }

    /**
     * drawOn -- draw this ball on the DrawSurface surFace.
     *
     * @param surface a DrawSurFace to draw the ball on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        //draw the ball.
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.r);
       //draw the circle.
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.r);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * setVelocity -- set the velocity of this ball with one we get as argument.
     *
     * @param v a velocity to define as the velocity of this ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity.set(v.getDx(), v.getDy());
    }

    /**
     * setGameEnvironment -- set the game environment of the ball with a new one.
     *
     * @param g is a new GUI.Collision.GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * setVelocity -- set the velocity of this ball with one we get as argument.
     *
     * @param dx is a value to define as the dx of the velocity of this ball .
     * @param dy is a value to define as the dy of the velocity of this ball .
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * moveOneStep -- move the ball to the next position he supposed to be.
     * if he is going to collision in a colidable Object, change the next position to be the collision point
     * and change the ball's velocity to bew the velocity the colidable Object return after hit.
     */
    public void moveOneStep() {
        if (this.velocity == null) {
            throw new RuntimeException("The velocity of the ball is not initialized");
        }
        //create line that represent the movement of the ball.
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
        //if the ball does not collision in collidable object move to the end of the line.
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.velocity.applyToPoint(this.center);
            return;
        }
        //else

        // set the velocity to the hit velocity.
        this.velocity.set(this.gameEnvironment.getClosestCollision(trajectory).collisionObject().hit(
                this.gameEnvironment.getClosestCollision(trajectory).collisionPoint(), this.getVelocity()));

        //move the ball near to the collition point.
        this.center.set(this.center.findGoodMovePoint(
                this.gameEnvironment.getClosestCollision(trajectory).collisionPoint()));
    }

    /**
     * sortBallsArrayFromBigToSmall -- Sort the Balls array so the biggest ball in the start and the
     * smallest at the end.
     *
     * @param array is the array to sort.
     * @param size  is the size of the array we want to sort.
     */
    public static void sortBallsArrayFromBigToSmall(Ball[] array, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j].r < array[j + 1].r) {
                    Ball temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
