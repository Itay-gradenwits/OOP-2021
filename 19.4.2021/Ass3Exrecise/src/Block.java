public class Block implements Collidable {

    private Triangle t;

    @Override
    public Triangle getCollisionTriAngle() {
        return t;
    }

    @Override
    /*it is pretty hard to implement with triangles
    with rectangle to the following steps:
    1.check if collisionPoint is on width segment:
            change dy to -dy
    2. check if collisionPoint is on height segment:
            change dx to -dx
     return new velocity.
    */

    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        return null;
    }
}
