import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args ){
        Pattern p = Pattern.compile("hello");
        String s = "hello world hello hello";
        Matcher m = p.matcher(s);
        while(m.find() == true) {
            System.out.println(s.substring(m.start(), m.end()));
        }
    }
}
