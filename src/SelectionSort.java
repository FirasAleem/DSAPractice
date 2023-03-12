import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[k]) {
                    k = j;
                    int temp = a[i]; //swap a[i]and a[k]
                    a[i] = a[k];
                    a[k] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            int[] array = new Random().ints(100000, 0, 100).toArray();

            final long startTime = System.currentTimeMillis();
            System.out.println("Starting sort");
            selectionSort(array, array.length);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time in milliseconds: " + (endTime - startTime));
        }
    }
}
