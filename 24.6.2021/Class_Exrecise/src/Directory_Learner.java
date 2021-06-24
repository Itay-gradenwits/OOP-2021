import java.io.File;
import java.util.Map;

public class Directory_Learner {
    private FileLearner fileLearner;

    public Directory_Learner(HypernymyCounter counter) {
        fileLearner = new FileLearner(counter);
    }

    public void learn_dir(String pathToDirectory, HypernymyCounter hypCounter) throws Exception{
            final File folder = new File(pathToDirectory);
            if(!folder.isDirectory())
                throw new Exception("not a directory");

            for (final File fileEntry : folder.listFiles()) {
                File absoluteFileEntry = new File(pathToDirectory + "/" + fileEntry.getName());
                fileLearner.learn_file(absoluteFileEntry);
            }
    }
}