package GUI.Collision;

import Geometry.Line;
import Geometry.Point;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Itay Gradenwits 213713522.
 */
public class GameEnvironment {

    private List<Collidable> collidableList;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        collidableList = new ArrayList<Collidable>();
    }

    /**
     * addCollidable -- add the given collidable to the environment.
     *
     * @param c is a Colidable object to add to the Coliable list of the game environment.
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * getClosestCollision  -- Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables, in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory is the line that represent the movment of an object from line.start to line.end
     * @return null if there is no collision of the moving object and one of the collidable objects
     * in the game environment. if there is an collision return the GUI.Collision.CollisionInfo about the collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (trajectory == null) {
            throw new RuntimeException("Geometry.Line is not initialized");
        }

        if (collidableList.isEmpty()) {
            return null;
        }

        //create a list that gonna hold the closest collition point of the trajectoryLine and the rectangles
        List<Point> closestPointsList = new ArrayList<Point>();

        // run all over the collidable objects and storage their closest point in the list from before.
        for (Collidable c : collidableList) {
            if (!c.getCollisionRectangle().intersectionPoints(trajectory).isEmpty()) {
                closestPointsList.add(trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()));
            }
        }

        //take the closest point from the closet collision points.
        Point closestPoint = trajectory.closestPointToStartFromAList(closestPointsList);
        Collidable closestObject;
        if (closestPoint == null) {
            return null;
        } else {
            // match the collidable objects that belong to this point to this point.
            closestObject = closestPoint.matchCollisionPointToCollidableObject(collidableList, trajectory);
        }
        return new CollisionInfo(closestPoint, closestObject);
    }

    /**
     * drawOn -- draw the all the sprite objects that the game hold on a DrawSurFace.
     * @param d is a drawSurface.
     */
    public void drawOn(DrawSurface d) {
        for (Collidable c : this.collidableList) {
            c.getCollisionRectangle().drawOn(d);
        }
    }
}
