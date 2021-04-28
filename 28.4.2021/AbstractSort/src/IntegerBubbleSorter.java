public class IntegerBubbleSorter extends AbstractBubbleSorter<Integer>{

    @Override
    protected int compare(Integer o1, Integer o2) {
        if(o1.intValue() < o2.intValue()) {
            return -1;
        }
        if(o1.intValue() == o2.intValue()) {
            return 0;
        }
        return 1;
    }
}
