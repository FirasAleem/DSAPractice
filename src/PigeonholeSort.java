import java.util.Random;

public class PigeonholeSort {
    public static void pigeonholeSort(int[] a, int length) {
        int[] b = new int[a.length];
        for (int i = 0; i < length; i++) {
            b[a[i]] = a[i];
        }
        System.arraycopy(b, 0, a, 0, a.length); //copies b to a
    }
    public static void pigeonholeSort_in_place(int[] a, int length){
        for (int i = 0; i < length; i++) {
            while (a[i] != i){
                int temp = a[i];
                a[i] = a[a[i]];
                a[a[i]] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new Random().ints(1000, 0, 100).toArray();
        long startTime = System.currentTimeMillis();
        pigeonholeSort(array, array.length);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time in milliseconds: " + (endTime - startTime));

        array = new Random().ints(1000, 0, 100).toArray();
        startTime = System.currentTimeMillis();
        pigeonholeSort_in_place(array, array.length);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time in milliseconds: " + (endTime - startTime));

    }
}
