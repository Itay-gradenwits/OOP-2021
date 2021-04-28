public class CharBubbleSorter extends AbstractBubbleSorter<Character> {
    @Override
    protected int compare(Character o1, Character o2) {
        if(o1.charValue() < o2.charValue()) {
            return -1;
        }
        if(o1.charValue() == o2.charValue()) {
            return 0;
        }

        return 1;
    }
}
