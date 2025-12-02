class MinHeap01 {
    int[] heap;
    int size;

    MinHeap01(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    void insert(int val) {
        if (size == heap.length) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = val;
        int i = size;
        size++;

        // Bubble up (min-heap condition)
        while (i > 0 && heap[i] < heap[parent(i)]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    int extractMin() {
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapify(smallest);
        }
    }

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class Minheap{
    public static void main(String[] args) {
        MinHeap01 mh = new MinHeap01(10);

        // Insert values
        mh.insert(50);
        mh.insert(40);
        mh.insert(30);
        mh.insert(20);
        mh.insert(10);
        mh.insert(60);
        mh.insert(70);

        System.out.println("Heap after insertion:");
        mh.printHeap();

        System.out.println("Extracted Min: " + mh.extractMin());
        mh.printHeap();

        System.out.println("Extracted Min: " + mh.extractMin());
        mh.printHeap();
    }
}
