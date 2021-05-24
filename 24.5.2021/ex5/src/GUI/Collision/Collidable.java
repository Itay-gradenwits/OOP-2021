package GUI.Collision;

import Geometry.Point;
import Geometry.Rectangle;
import Movement.Velocity;

/**
 * @author Itay Gradenwits 213713522.
 */
public interface Collidable {

    /**
     * getCollisionRectangle -- Return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit -- Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  is the point where the collision gonna happen.
     * @param currentVelocity is the velocity of the collision object.
     * @return a new Movement.Velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}