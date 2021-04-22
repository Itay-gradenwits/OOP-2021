public class Main {
    public static void main(String[] args) {
        try {
            Hotel hotel = Hotel.fromMainArguments(args);
            System.out.println("the profit is " + hotel.getProfit());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
