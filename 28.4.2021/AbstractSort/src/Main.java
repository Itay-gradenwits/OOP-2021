public class Main {
    public static void main (String[] args){
        Integer[] arr1 = {2,4,1,3,-12,0,-43,211,142,321,1212,-3333,2123,32312,4443,77};
        Character[] arr2 = {'g', 's', 'i', 'b', 'd', 'w', 'q', 'a', 'z', 'v', 'p'};

        IntegerBubbleSorter integerSorter = new IntegerBubbleSorter();
        CharBubbleSorter charBubbleSorter = new CharBubbleSorter();

        integerSorter.sort(arr1);
        charBubbleSorter.sort(arr2);

        System.out.println("sorted int array:");
        printIntArray(arr1);

        System.out.println();

        System.out.println("sorted char array:");
        printCharArray(arr2);

    }


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
