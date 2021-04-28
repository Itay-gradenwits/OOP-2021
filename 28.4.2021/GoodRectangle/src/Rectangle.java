/**
 * @author Itay Gradenwits 213713522.
 */
public class Rectangle {
     private Point upperLeft;
     private int width;
     private int height;
    /**
     * Constructor.
     * @param x is a value to define as the x value of the left and upper point of the rectangle
     * @param y is a value to define as the y value of the left and upper point of the rectangle
     * @param width is a value to define as the width of the rectangle.
     * @param height is a value to define as the height of the rectangle.
     */
    public Rectangle(int x, int y, int width, int height) throws Exception{
        if(width <=0 ) {
            throw new RectangleException(0);
        }
        if(height <= 0) {
            throw new RectangleException(1);

        }
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * getWidth.
     * @return the width of the rectangle
     */
     public double getWidth() {
        return this.width;
    }

    /**
     * getHeight.
     * @return the height of the rectangle.
     */
    public double getHeight() {
         return this.height;
    }

    /**
     * getLeftAndUpperPoint.
     * @return the left anf upper point of the rectangle.
     */
    public Point getLeftAndUpperPoint() {
         return this.upperLeft;
    }
}
