import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] a, int length, boolean stable){
        quickSort_run(a, 0, length-1, stable);
    }

    private static void quickSort_run(int[] a, int left, int right, boolean stable){
        if (left < right){
            int pivotIndex;
            if (stable){
                pivotIndex = partition_stable(a, left , right);
            }else {
                pivotIndex = partition_unstable(a, left , right);
            }
            quickSort_run(a, left , pivotIndex-1, stable);
            quickSort_run(a, pivotIndex+1, right, stable);
        }
    }

    private static int partition_unstable(int[] a, int left, int right){
        int pivotIndex = choosePivot(a, left, right);
        int pivot = a[pivotIndex];
        int temp = a[right];
        a[right] = a[pivotIndex];
        a[pivotIndex] = temp;
        int leftMark = left;
        int rightMark = right - 1;
        while (leftMark <= rightMark){
            while ((leftMark <= rightMark) && (a[leftMark] <= pivot)){
                leftMark++;
            }
            while ((leftMark <= rightMark) && (a[rightMark] >= pivot)){
                rightMark--;
            }
            if (leftMark < rightMark){
                int temp2 = a[leftMark];
                a[leftMark] = a[rightMark];
                a[rightMark] = temp2;
                leftMark++;
                rightMark--;
            }
        }
        int temp3 = a[leftMark];
        a[leftMark] = a[right];
        a[right] = temp3;
        return leftMark;
    }

    private static int partition_stable(int[] a, int left, int right){
        int[] b = new int[(right-left+1)];
        int pivotIndex = choosePivot(a, left, right);
        int pivot = a[pivotIndex];
        int acount = left;
        int bcount = 0;
        for (int i = left; i <= right ; i++) {
            if (i == pivotIndex){
                b[0] = a[i];
            }else if ((a[i] < pivot) || (a[i] == pivot && i < pivotIndex)){
                a[acount] = a[i];
                acount++;
            }else{
                b[bcount] = a[i];
                bcount++;
            }
        }
        for (int i = 0 ; i < bcount ; i++ ){a[acount++] = b[i];}
        return (right-bcount+1);
    }

    private static int choosePivot(int[] a, int left, int right){
        return a.length/2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            int[] array = new Random().ints(1000000, 0, 100).toArray();

            final long startTime = System.currentTimeMillis();
            System.out.println("Starting sort");
            quickSort(array, array.length, false);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time in milliseconds: " + (endTime - startTime));
        }
    }
}
