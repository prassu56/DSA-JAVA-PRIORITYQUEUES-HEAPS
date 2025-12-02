/* example for minimum heap value */
import java.util.Collections;
import java.util.PriorityQueue;
public class Priorityqueues {
    public static void main(String[] args) {
        // Create a priority queue (min-heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); /*  maximum  value deletion */

        // Add elements to the priority queue
        pq.add(10);
        pq.add(15);
        pq.add(30);
        pq.poll(); /*  minimum  value deletion */
        System.out.println("PQ"+pq);
        
    }
}
