public class Main {
    public static double CalculateRectangleArea(Rectangle rectangle) {
       return rectangle.getHeight() * rectangle.getWidth();
    }
    public static void main (String[] args) {
        try {
            Rectangle rectangle = new Rectangle(0, 0, -4, 5);
            System.out.println("the rectangle area is: " + CalculateRectangleArea(rectangle));
        }
        catch (RectangleException e) {
            System.out.print(e.getErrorMessage());
        }
        catch (Exception e) {
            System.out.print("...");
        }
    }
}