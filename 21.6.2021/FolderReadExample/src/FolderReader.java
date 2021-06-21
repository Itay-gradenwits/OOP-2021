import java.io.*;

public class FolderReader {
    private String path;
    public FolderReader(String path) {
        this.path = path;
    }
    public void readToFile(String path) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));

        final File folder = new File(this.path);
        if(!folder.isDirectory())
            throw new Exception("not a directory");

        for (final File fileEntry : folder.listFiles()) {
            File absoluteFileEntry = new File(this.path + "/" + fileEntry.getName());
            BufferedReader reader = new BufferedReader(new FileReader(absoluteFileEntry));
            String line;
            while(((line = reader.readLine()) != null)) {
                writer.write(line +"\r\n");
            }
            reader.close();
        }
        writer.close();
    }
}
