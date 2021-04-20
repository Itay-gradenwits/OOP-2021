public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidableObject;

    public CollisionInfo(Point p, Collidable t) {
        collisionPoint = p;
        collidableObject = t;
    }


    public Point collisionPoint() {
        return this.collisionPoint;
    }

    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.collidableObject;
    }
}
