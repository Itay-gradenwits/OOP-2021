public class Main {
    public static double CalculateRectangleSum(Rectangle rectangle) {
       return rectangle.getHeight() * rectangle.getWidth();
    }
    public static void main (String[] args) {
        Rectangle rectangle = new Rectangle(0,0,3,5);
        System.out.println("the rectangle sum is: " + CalculateRectangleSum(rectangle));
    }
}
