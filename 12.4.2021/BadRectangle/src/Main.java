public class Main {

    public static int CalculateRectangleSum(Rectangle rectangle) {
       return rectangle.height * rectangle.width;
    }


    public static void main (String[] args) {
        Rectangle rectangle = new Rectangle(0,0,4,5);
        System.out.println("the rectangle sum is: " + CalculateRectangleSum(rectangle));
    }
}
