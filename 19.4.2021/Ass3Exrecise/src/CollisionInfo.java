 public class CollisionInfo {
        private Point collisionPoint;
        private Collidable collisionObject;

        // the point at which the collision occurs.
        public Point collisionPoint() {
            return collisionPoint;
        }

        // the collidable object involved in the collision.
        public Collidable collisionObject() {
            return collisionObject;
        }
    }


