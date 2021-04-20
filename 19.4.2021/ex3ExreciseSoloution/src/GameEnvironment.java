import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {

    List<Collidable> collidables;

    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        double min = 0;
        Collidable closestTriangle = null;
        Point closestPoint = null;
        boolean first = true;
        for (Collidable t : collidables) {
            Point p = trajectory.closestIntersectionToStartOfLineTriangle(t.getCollisionTriangle());
            if (p != null) {
                if (first) {
                    first = false;
                    min = p.distance(trajectory.start());
                    closestTriangle = t;
                    closestPoint = p;
                } else {
                    if(p.distance(trajectory.start()) < min) {
                        min = p.distance(trajectory.start());
                        closestTriangle = t;
                        closestPoint = p;
                    }
                }
            }
        }
        if(closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, closestTriangle);
    }

    void drawAllOn(DrawSurface d) {
        for (Collidable c : this.collidables) {
            c.getCollisionTriangle().drawOn(d);
        }
    }
}
