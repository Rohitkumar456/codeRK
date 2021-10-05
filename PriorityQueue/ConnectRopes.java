import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of integers A representing the length of ropes.

    You need to connect these ropes into one rope. The cost of connecting two ropes is equal to the sum of their lengths.

    Find and return the minimum cost to connect these ropes into one rope.
 *
 * Example Input
        Input 1:                                Output 1:
        A = [1, 2, 3, 4, 5]                         33

        Input 2:                                Output 2:- 
        A = [5, 17, 100, 11]                        182


 */

public class ConnectRopes {
    public static void main(String[] args) {
        ConnectRopes cr = new ConnectRopes();
        int[] a = {5, 17, 100, 11};
        int ans = cr.getMinCost(a);
        System.out.println(ans);
    }

    public int getMinCost(int[] a){
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        for(int x:a) minHeap.add(x);

        int cost = 0;

        while(minHeap.size()>=2){
            int f = minHeap.poll();
            int s = minHeap.poll();
            int sum = f+s;
            cost+=sum;
            minHeap.add(sum);
        }
        return cost;

    }
}
