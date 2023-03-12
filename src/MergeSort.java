import java.util.Random;

public class MergeSort {

    public static int recursive_calls = 0;

    public static void mergesort(int[] a, int length) {
        mergesort_run(a, 0, length - 1);
    }

    private static void mergesort_run(int[] a, int left, int right) {
        recursive_calls++;
        System.out.println("recursive call to mergesort_run: " + recursive_calls);

        if (left < right) {
            int mid = (left + right) / 2;

            mergesort_run(a, left, mid);
            mergesort_run(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] b = new int[(right - left + 1)];
        int bcount = 0;
        int lcount = left;
        int rcount = mid + 1;

        while ((lcount <= mid) && (rcount <= right)) {
            if (a[lcount] <= a[rcount]) {
                b[bcount++] = a[lcount++];
            } else {
                b[bcount++] = a[rcount++];
            }
        }
        if (lcount > mid) {
            while (rcount <= right) {
                b[bcount++] = a[rcount++];
            }
        } else {
            while (lcount <= mid) {
                b[bcount++] = a[lcount++];
            }
        }
        for (bcount = 0; bcount < (right - left + 1); bcount++) {
            a[(left + bcount)] = b[bcount];
        }
    }


    public static void main(String[] args) {
        //int[] array = {563, 12, 531, 740, 970, 177, 181, 898};
        //int[] array = {1,2,3,4,5,6,7};
        for (int i = 1; i <2000; i++) {
            final long startTime = System.currentTimeMillis();

            int[] array = new Random().ints(i, 0, 2147483640).toArray();
            System.out.println("array size: " + i);
            for (int j : array) {
                System.out.print(j + ", ");
            }
            System.out.println();
            mergesort(array, array.length);
            System.out.println("Recursive calls: " + recursive_calls);
            for (int j : array) {
                System.out.print(j + ", ");
            }
            System.out.println();
            System.out.println("Array size: " + array.length + ". Recursive calls: " + recursive_calls);
            recursive_calls = 0;
            final long endTime = System.currentTimeMillis();

            System.out.println("Total execution time: " + (endTime - startTime));

        }
    }
}

