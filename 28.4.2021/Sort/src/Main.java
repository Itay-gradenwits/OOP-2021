public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 4, 2, 1, 3, 133, 22, 44, -332, 222, 111, 0, 32, 12, 444, 212, 32, 123, 121};
        Character[] arr2 = {'g', 's', 'i', 'b', 'd', 'w', 'q', 'a', 'z', 'v', 'p'};

        BubbleSorter<Character> charBubbleSorter = new BubbleSorter<>(new CharComparator());
        BubbleSorter<Integer> intBubbleSorter = new BubbleSorter<>(new IntComparator());

        intBubbleSorter.sort(arr1);
        charBubbleSorter.sort(arr2);

        System.out.println("sorted int array:");
        printIntArray(arr1);

        System.out.println();

        System.out.println("sorted char array:");
        printCharArray(arr2);

    }



    //the smarter thing to do is to create a generic interface printer who can print arrays.
    public static void printCharArray(Character[] arr) {
        for(Character c : arr) {
            System.out.print(c.charValue());
            System.out.print(",");
        }
    }

    public static void printIntArray(Integer[] arr) {
        for(Integer x : arr) {
            System.out.print(x);
            System.out.print(",");

        }
    }
}
