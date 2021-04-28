import java.util.Comparator;

public class IntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.intValue() < o2.intValue()){
            return -1;
        }
        if(o1.intValue() == o2.intValue()) {
            return 0;
        }
        //01>02
        return 1;
    }
}
