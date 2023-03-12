public class PriorityHeap {
    private final int MAX = 100;
    private int[] heap = new int[MAX + 1];
    private int n = 0;

    public int value(int i) {
        if (i < 1 || i > n) {
            throw new IndexOutOfBoundsException();
        }
        return heap[i];
    }

    public boolean isRoot(int i) {
        return i == 1;
    }

    public int level(int i) {
        return (int) (Math.log(i) / Math.log(2)); //same as return log(i)
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return (2 * i) + 1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int root() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            return heap[1];
        }
    }

    public int lastLeaf() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            return heap[n];
        }
    }

    //up to here is all methods from W7-02

    public void insert(int p) throws Exception {
        if (n == MAX) {
            throw new Exception();
        }
        n = n + 1;
        heap[n] = p; // insert the new value as the last node of the last level
        bubbleUp(n); // and bubble it up
    }

    private void bubbleUp(int i) {
        if (i == 1) return; //i is the root
        if (heap[i] > heap[parent(i)]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            bubbleUp(parent(i));
        }
    }

    //up to here is all methods from W7-03

    public void deleteRoot() throws Exception {
        if (n < 1)
            throw new Exception();
        heap[1] = heap[n];
        n = n - 1;
        bubbleDown(1);
    }

    private void bubbleDown(int i) {
        if (left(i) > n) {
            return;
        } else if (right(i) > n) {
            if (heap[i] < heap[left(i)]) {
                int temp = heap[i];
                heap[i] = heap[left(i)];
                heap[left(i)] = temp;
            }
        } else if (heap[left(i)] > heap[right(i)] && heap[i] < heap[left(i)]) {
            int temp = heap[i];
            heap[i] = heap[left(i)];
            heap[left(i)] = temp;
            bubbleDown(left(i));
        } else if (heap[i] < heap[right(i)]) {
            int temp = heap[i];
            heap[i] = heap[right(i)];
            heap[right(i)] = temp;
            bubbleDown(right(i));
        }
    }

    public void delete(int i) throws Exception {
        if (n < 1) {
            throw new Exception("Empty Heap");
        }
        if (i < 1 || i > n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        heap[i] = heap[n];
        n = n - 1;
        bubbleUp(i);
        bubbleDown(i);
    }

    public void update(int i, int position) throws Exception {
        if (n < 1) {
            throw new Exception("Empty Heap");
        }
        if (i < 1 || i > n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        heap[i] = position;
        bubbleUp(i);
        bubbleDown(i);
    }

    //up to here is all methods from W7-03

    public void heapify() {
        for (int i = n / 2; i > 0; i--) {
            bubbleDown(i);
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityHeap heap1 = new PriorityHeap();
        int[] array = {10, 50, 25, 80, 35, 20, 65, 40, 30, 75, 15, 45, 90};
        for (int num: array) {
            heap1.insert(num);
        }
        for (int num: heap1.heap) {
            System.out.printf("%d, ", num);
        }
    }
}

