public class Main {
    public static void main(String[] args) {
        try {
            DirectorySearcher d = new DirectorySearcher(args[0]);
            d.addSearcher("hello");
            d.addSearcher("test");

            d.writeMatchesToFile(args[1]);
        }
        catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}
