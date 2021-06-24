import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchChecker {
    enum Option {
        Regex_1,
        Regex_2,
        Regex_3,
        Regex_4,
        Regex_5,
    }
    //change regexes.
    final private String regex_1 = "hello";
    final private String regex_2 = "bye";
    final private String regex_3 = "bye";
    final private String regex_4 = "bye";
    final private String regex_5 = "bye";

    public Map<String, MatchChecker.Option> checkMatches(String line) {
        Map<String, MatchChecker.Option> map = new TreeMap<>();

        Pattern p1 = Pattern.compile(regex_1);
        Matcher m1 = p1.matcher(line);

        Pattern p2 = Pattern.compile(regex_2);
        Matcher m2 = p1.matcher(line);

        Pattern p3 = Pattern.compile(regex_3);
        Matcher m3 = p1.matcher(line);

        Pattern p4 = Pattern.compile(regex_4);
        Matcher m4 = p1.matcher(line);

        Pattern p5 = Pattern.compile(regex_5);
        Matcher m5 = p1.matcher(line);

        while(m1.find() == true) {
            map.put(line.substring(m1.start(), m1.end()), Option.Regex_1);
        }
        while(m2.find() == true) {
            map.put(line.substring(m1.start(), m1.end()), Option.Regex_1);
        }
        while(m3.find() == true) {
            map.put(line.substring(m1.start(), m1.end()), Option.Regex_1);
        }
        while(m4.find() == true) {
            map.put(line.substring(m1.start(), m1.end()), Option.Regex_1);
        }
        while(m5.find() == true) {
            map.put(line.substring(m1.start(), m1.end()), Option.Regex_1);
        }
        return map;
    }
}
