import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLearner {
    private LineLearner lineLearner;

    public FileLearner(HypernymyCounter counter) {
        lineLearner = new LineLearner(counter);
    }

    public void learnFile(String pathToFile, HypernymyCounter counter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line;
        while ((line = reader.readLine()) != null) {
            lineLearner.learnLine(line);
        }
    }

}
