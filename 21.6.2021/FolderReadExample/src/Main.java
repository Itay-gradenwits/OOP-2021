public class Main {
    public static void main(String[] args) {
        try {
            FolderReader fr = new FolderReader(args[0]);
            fr.readToFile(args[1]);
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
