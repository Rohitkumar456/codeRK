import java.util.PriorityQueue;

/**
 * 
 * Misha loves eating candies. She has given N boxes of Candies.

    She decides, every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
    Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

    NOTE 1: If a box has an odd number of candies then Misha will eat floor(odd/2).

    NOTE 2: A same box will not be chosen again.
 */

public class MishaAndCandies {
    public static void main(String[] args) {
        MishaAndCandies mc = new MishaAndCandies();
        int[] a = {1,2,1};
        int b = 2;

        int ans = mc.numberOfCandies(a, b);
        System.out.println(ans);
        
    }

    public int numberOfCandies(int[] a, int b){
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        for(int x:a) minHeap.add(x);

        int totalCandies = 0;

        while(minHeap.size()>0&&minHeap.peek()<=b){
            int candie = minHeap.poll();
            int half = candie/2;
            totalCandies+=half;
            if(minHeap.size()>0){
                int next = minHeap.poll();
                next+=(candie-half);
                minHeap.add(next);
            }else break;
        }
        return totalCandies;
    }
}
