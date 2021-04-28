public abstract class AbstractBubbleSorter<T> implements Sorter<T> {

    protected abstract int compare(T o1, T o2);

    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        T temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (compare(arr[j - 1], arr[j]) == 1) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

}
