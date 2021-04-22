/**
 * @author Itay Gradenwits 213713522.
 */
public class Rectangle {
     public Point upperLeft;
     public int width;
     public int height;

    /**
     * Constructor.
     * @param x is a value to define as the x value of the left and upper point of the rectangle
     * @param y is a value to define as the y value of the left and upper point of the rectangle
     * @param width is a value to define as the width of the rectangle.
     * @param height is a value to define as the height of the rectangle.
     */
    public Rectangle(int x, int y, int width, int height) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }
}
