/**
 * 
 */

import java.util.*;

public class priorityQueueBasics {
    public static void main(String[] args) {
        


        PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });

        pq.add(1);
        pq.add(2);
        pq.add(3);

        System.out.println(pq.peek());
    }
}
