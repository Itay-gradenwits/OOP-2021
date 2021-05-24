package GUI.Collision;

import Game.Game;
import Geometry.Point;
import Geometry.Rectangle;
import Movement.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import GUI.Sprite;


/**
 * @author Itay Gradenwits 213713522.
 */
public class Paddle implements Collidable, Sprite {

    private static final double EPSILON = Math.pow(10, -6);
    private static final int VELOCITY = 10;
    private Rectangle rectangle;
    private biuoop.KeyboardSensor keyboard;
    private double leftLimit;
    private double rightLimit;

    /**
     * constructor.
     *
     * @param gui           is a gui to define as as the Paddle.
     * @param rectangle     is a rectangle to define as the rectangle of the Paddle.
     * @param widthOfFrame  is a number to define as the widthFrame of the paddle.
     * @param widthOfScreen is a number to define as the widthOgScreen of the paddle.
     */
    public Paddle(GUI gui, Rectangle rectangle, double widthOfFrame, double widthOfScreen) {
        if (rectangle == null) {
            throw new RuntimeException("the rectangle is not initialized");
        }
        if (gui == null) {
            throw new RuntimeException("the gui object is not initialized");
        }
        this.rectangle = new Rectangle(rectangle.getUpperLeft(), rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getColor());
        keyboard = gui.getKeyboardSensor();
        this.leftLimit = widthOfFrame;
        this.rightLimit = widthOfScreen - widthOfFrame;
    }

    /**
     * move the rectangle of the paddle to the left according to the right limit and VELOCITY.
     */
    public void moveLeft() {
        //if the next step of the paddle get out of the left limit
        if ((int) this.getCollisionRectangle().getUpperLeft().getX() - VELOCITY <= this.leftLimit) {
            //move it to the left limit
            this.rectangle.set(new Point(this.leftLimit, this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight(), this.rectangle.getColor());

            //if not
        } else {
            //move the paddle VELOCITY units to the left.
            this.rectangle.set(new Point(this.rectangle.getUpperLeft().getX() - VELOCITY,
                            this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(),
                    this.rectangle.getHeight(), this.rectangle.getColor());
        }
    }

    /**
     * MoveRight -- move the rectangle of the paddle to the right according to the right limit and VELOCITY.
     */
    public void moveRight() {
        //if the next step of the paddle get out of the right limit
        if ((int) this.getCollisionRectangle().getUpperLeft().getX() + this.getCollisionRectangle().getWidth()
                + VELOCITY >= this.rightLimit) {
            //move it to the left limit
            this.rectangle.set(new Point(this.rightLimit - this.rectangle.getWidth(),
                    this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight(),
                    this.rectangle.getColor());

            //if not
        } else {
            //move the paddle VELOCITY units to the left.
            this.rectangle.set(new Point(this.rectangle.getUpperLeft().getX()
                            + VELOCITY, this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(),
                    this.rectangle.getHeight(), this.rectangle.getColor());
        }
    }

    @Override
    // GUI.Sprite
    public void timePassed() {
        //if the left key is pressed.
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && !(keyboard.isPressed(KeyboardSensor.RIGHT_KEY))) {
            moveLeft();

            // if the right key is pressed
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && !(keyboard.isPressed(KeyboardSensor.LEFT_KEY))) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
    }

    // Collidable
    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.rectangle.getUpperLeft(), this.rectangle.getWidth(), this.rectangle.getHeight(),
                this.rectangle.getColor());
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        int d = (int) this.getCollisionRectangle().getWidth() / 5;

        //if it is in the first part//
        if (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX(), collisionPoint.getX())
                || ((isLeftSmallerThanRight(collisionPoint.getX(), this.getCollisionRectangle().getUpperLeft().getX()
                + d))
                        && (isLeftSmallerThanRight(this.getCollisionRectangle().getUpperLeft().getX(),
                collisionPoint.getX())))) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }

        //if it is in the second part//
        if (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX() + d, collisionPoint.getX())
                || ((isLeftSmallerThanRight(collisionPoint.getX(), this.getCollisionRectangle().getUpperLeft().getX()
                + 2 * d))
                        && (isLeftSmallerThanRight(this.getCollisionRectangle().getUpperLeft().getX()
                + d, collisionPoint.getX())))) {

            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        }

        //if it is in the third part//
        if (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX() + 2 * d, collisionPoint.getX())
                || ((isLeftSmallerThanRight(collisionPoint.getX(), this.getCollisionRectangle().getUpperLeft().getX()
                + 3 * d))
                        && (isLeftSmallerThanRight(this.getCollisionRectangle().getUpperLeft().getX()
                + 2 * d, collisionPoint.getX())))) {

            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }

        //if it is in the forth part//
        if (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX() + 3 * d, collisionPoint.getX())
                || ((isLeftSmallerThanRight(collisionPoint.getX(), this.getCollisionRectangle().getUpperLeft().getX()
                + 4 * d))
                        && (isLeftSmallerThanRight(this.getCollisionRectangle().getUpperLeft().getX()
                + 3 * d, collisionPoint.getX())))) {

            return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }

        //if it is in the fifth part//
        if (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX() + 4 * d, collisionPoint.getX())
                || (isLeftWorthRight(this.getCollisionRectangle().getUpperLeft().getX()
                + this.getCollisionRectangle().getWidth(), collisionPoint.getX()))
                || ((isLeftSmallerThanRight(collisionPoint.getX(), this.getCollisionRectangle().getUpperLeft().getX()
                + this.getCollisionRectangle().getWidth()))
                        && (isLeftSmallerThanRight(this.getCollisionRectangle().getUpperLeft().getX()
                + 4 * d, collisionPoint.getX())))) {

            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        throw new RuntimeException("the Collision point is not on the paddle");
    }

    /**
     * isLeftSmallerThanRight -- compare 2 doubles.
     * @param x is the left number.
     * @param y is the right number.
     * @return true if x < y and false other wise.
     */
    private static boolean isLeftSmallerThanRight(double x, double y) {
        return (y - x) > EPSILON;
    }

    /**
     * isLeftWorthRight -- compare 2 doubles.
     * @param x is the left number.
     * @param y is the right number.
     * @return true if x == y and false other wise.
     */
    private static boolean isLeftWorthRight(double x, double y) {
        return Math.abs(x - y) < EPSILON;
    }

    /**
     * addToGame Add this paddle to the game.
     * @param g is a game to add the paddle into.
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
