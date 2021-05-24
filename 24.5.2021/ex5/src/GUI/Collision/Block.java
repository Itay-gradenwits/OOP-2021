package GUI.Collision;

import GUI.Sprite;
import Geometry.Point;
import Geometry.Rectangle;
import Movement.Velocity;
import biuoop.DrawSurface;

/**
 * @author Itay Gradenwits 213713522.
 */
public class Block implements Collidable, Sprite {

    private Rectangle rectangle;

    /**
     * constructor.
     *
     * @param rect is a rectangle to define as the rectangle of the block.
     */
    public Block(Rectangle rect) {
        this.rectangle = rect;
    }

    /**
     * getCollisionRectangle -- Return the rectangle of the block.
     *
     * @return the rectangle of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /**
     * hit -- return a new Movement.Velocity , according to collision in the block and the current velocity.
     *
     * @param collisionPoint  is the collision point on the rectangle.
     * @param currentVelocity is the current velocity of the thing that collision the rectangle.
     * @return a new Movement.Velocity:
     * if the collision point is on the width lines of the rectangle ,Dx of the new Movement.Velocity = -Dx currentVelocity.
     * if the collision point is on the height lines of the rectangle, Dy of the new Movement.Velocity = -Dy currentVelocity.
     * if the collision point is not in one of the rectangle segments so newVelocity = currentVelocity.
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        if (this.rectangle == null) {
            throw new RuntimeException("the rectangle is not initialized");
        }

        // create a velocity witch identity to the current one.
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (collisionPoint == null) {
            throw new RuntimeException("the collisionPoint is not initialized");
        }
        //if the collision point is on a widthSegment change dy.
        if (rectangle.isPointOnWidthSegments(collisionPoint)) {
            newVelocity.setDy(-newVelocity.getDy());
        }

        //if the collision point is on a heightSegment change dx.
        if (rectangle.isPointOnHeightSegments(collisionPoint)) {
            newVelocity.setDx((-newVelocity.getDx()));
        }
        return newVelocity;
    }

    /**
     * drawOn -- draw the block on a drawSurface object.
     *
     * @param d is a drawSurface Object.
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawOn(d);
    }

    @Override
    public void timePassed() {
        return;
    }
}
