import java.util.Comparator;

public class CharComparator implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        if(o1.charValue() < o2.charValue()) {
            return -1;
        }
        if(o1.charValue() == o2.charValue()) {
            return 0;
        }
        //o1>o2
        return 1;
    }
}
