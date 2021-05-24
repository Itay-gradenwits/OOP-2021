public class Main {
    public static void main(String[] args) {
        try {
            GaurdiansOfTheWalls g = new GaurdiansOfTheWalls();
            g.begin();
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
