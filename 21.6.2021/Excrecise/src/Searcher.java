import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    String regex;
    public Searcher(String r) {
        this.regex = r;
    }
    public List<String> search (String line) {
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(line);
        List<String> l = new ArrayList<>();
        while((m.find()) == true) {
            l.add(line.substring(m.start(), m.end()));
        }
        return l;
    }
}
