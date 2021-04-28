import java.util.Comparator;

public class BubbleSorter<T> implements Sorter<T> {
    private Comparator<T> comparator;

    public BubbleSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        T temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (comparator.compare(arr[j - 1], arr[j]) == 1) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

}
