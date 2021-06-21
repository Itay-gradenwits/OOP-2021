import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorySearcher {
    private String pathToDirectory;
    List<Searcher> searcherList = new ArrayList<>();
    public DirectorySearcher(String pathToDirectory) {
        this.pathToDirectory = pathToDirectory;
    }
    public void addSearcher(String regex) {
        searcherList.add(new Searcher(regex));
    }
    public void writeMatchesToFile(String output) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
        final File folder = new File(this.pathToDirectory);
        if(!folder.isDirectory())
            throw new Exception("not a directory");

        for (final File fileEntry : folder.listFiles()) {
            File absoluteFileEntry = new File(this.pathToDirectory + "/" + fileEntry.getName());
            BufferedReader reader = new BufferedReader(new FileReader(absoluteFileEntry));
            String line;
            while(((line = reader.readLine()) != null)) {
                for(Searcher s : searcherList) {
                    for (String word : s.search(line)) {
                        writer.write(word + "\r\n");
                    }
                }
            }
            reader.close();
        }
        writer.close();
    }
}
