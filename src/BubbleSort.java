import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int[] a, int length){
        for (int i = 1 ; i < length ; i++ ){
            for (int j = length-1; j >= i ; j--) {
                if ( a[j] < a[j-1] ){
                    int temp = a[j]; //swapping a[j] and a[j-1]
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            int[] array = new Random().ints(10000, 0, 100).toArray();
            //        for (int j : array) {
            //            System.out.print(j + ", ");
            //        }
            //        System.out.println();

            final long startTime = System.currentTimeMillis();
            bubbleSort(array, array.length);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));

            //        for (int j : array) {
            //            System.out.print(j + ", ");
            //        }
            //        System.out.println();
        }
    }
}
