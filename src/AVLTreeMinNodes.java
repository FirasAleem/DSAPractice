import java.math.BigInteger;

/**
 * @author Firas
 * Short program to find the minimum number of nodes af an AVL tree of a given height, works recursively
 * Written for Quiz 3 (even though I really didn't need to)
 */


public class AVLTreeMinNodes {
    public static long minNodes(long height) {

        long two = 2;
        if (height == 0) {
            return 1;
        } else if (height == 1) {
            return 2;
        } else{
            return (1 + minNodes((height-2)) + minNodes((height-1)));
        }
    }

    public static int minNodes(int height) {
        if (height == 0) {
            return 1;
        } else if (height == 1) {
            return 2;
        } else {
            return (1 + minNodes((height - 2)) + minNodes((height - 1)));
        }
    }

    public static void main(String[] args) {
        for (long i = 0; i < 4000; i++) {
            System.out.printf("Min Nodes at Height %d is: %d%n", i, minNodes(i));
        }
    }
}
