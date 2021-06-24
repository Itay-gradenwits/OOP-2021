import java.util.List;
import java.util.Map;

public class LineLearner {
    private HypernymyCounter counter;
    private MatchChecker matchChecker;
    private MatchParser matchParser;

    public LineLearner(HypernymyCounter counter) {
        this.counter = counter;
        matchChecker = new MatchChecker();
        matchParser = new MatchParser();
    }
    public void learnLine(String line) {
        Map<String, MatchChecker.Option> matches = matchChecker.checkMatches(line);
        List<Hypernymy> hypernymies = MatchParser.parseMap(matches);
        counter.updateMap(hypernymies);
    }
}

/*parse converts:
{(fruit such as banana and orange, 1), (game such as football, 1)}

to:
{(fruit, banana), (fruit, orange), (game,soccer) }*/
