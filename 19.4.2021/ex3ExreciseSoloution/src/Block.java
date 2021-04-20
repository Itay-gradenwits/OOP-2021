public class Block implements Collidable {
    private Triangle t;

    public Block(int x1, int y1, int x2, int y2, int x3, int y3) {
        t = new Triangle(x1,y1,x2,y2,x3,y3);
    }

    @Override
    public Triangle getCollisionTriangle() {
        return t;
    }

    @Override
    public Velocity hit(Point startMove, Point collisionPoint, Velocity currentVelocity) {
        //soon
        Line segment = t.getCollisionSegment(collisionPoint);
        double a = startMove.distance(collisionPoint);
        double b = segment.start().distance(collisionPoint);
        double c = segment.start().distance(startMove);
        double hitAngle = Math.toDegrees(Math.acos((c*c-a*a-b*b)/(-2*a*b)));
        if (hitAngle > 90) {
            hitAngle = 180- hitAngle;
        }
        double newAngle = currentVelocity.getAngle() -2 * hitAngle;
        Velocity v = Velocity.fromAngleAndSpeed(newAngle, currentVelocity.getSpeed());
        return v;
    }
}
