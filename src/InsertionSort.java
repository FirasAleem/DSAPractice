import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] a, int length){
        for (int i = 0; i < length; i++) {
            int j = i;
            int t = a[j];
            while ( j > 0 && t < a[j-1] ) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] array = new Random().ints(1000000, 0, 100).toArray();
            //        for (int j : array) {
            //            System.out.print(j + ", ");
            //        }
            //        System.out.println();

            final long startTime = System.currentTimeMillis();
            insertionSort(array, array.length);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time in milliseconds: " + (endTime - startTime));

            //        for (int j : array) {
            //            System.out.print(j + ", ");
            //        }
            //        System.out.println();
        }
    }

}
