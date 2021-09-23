/**
 * 
 */

import java.util.*;

public class priorityQueueBasics {
    public static void main(String[] args) {
        


        PriorityQueue<Integer>pq = new PriorityQueue<>(Comparator.reverseOrder());


        System.out.println(pq.remove());
    }
}
