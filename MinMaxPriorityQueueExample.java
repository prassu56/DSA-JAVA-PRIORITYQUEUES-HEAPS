class MaxHeap01 {
    int[] heap;
    int size;

    MaxHeap01(int capacity) {
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
        while (i > 0 && heap[i] > heap[parent(i)]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }
    int extractMax(){
        int root=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapify(0);
        return root;
    }
    void heapify(int i){
        int largest=i;
        int l=left(i);
        int r=right(i);
        if(l<size && heap[l]>heap[largest]) largest =l;
        if(l<size && heap[r]>heap[largest]) largest =r;
        if(largest !=i){
            int temp=heap[i];
            heap[i]=heap[largest];
            heap[largest]=temp;
            heapify(largest);
        }
    }

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class MinMaxPriorityQueueExample {
    public static void main(String[] args) {
        MaxHeap01 mp = new MaxHeap01(10);  // capacity 10

        // Insert values
        mp.insert(10);
        mp.insert(20);
        mp.insert(30);
        mp.insert(40);
        mp.insert(50);
        mp.insert(60);
        mp.insert(70);

        System.out.println("Heap after insertion:");
        mp.printHeap();

        // Extract max
        System.out.println("Extracted Max: " + mp.extractMax());
        System.out.println("Heap after extracting max:");
        mp.printHeap();

        // Extract another max
        System.out.println("Extracted Max: " + mp.extractMax());
        System.out.println("Heap after extracting max:");
        mp.printHeap();
    }
}

