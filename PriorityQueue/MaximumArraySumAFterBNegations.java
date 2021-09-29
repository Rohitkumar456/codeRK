import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

    You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 * 
 * fir ex:- A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
            B = 10
             
            Answer:- Final array after B negations [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
                    SUm = 362

 */

public class MaximumArraySumAFterBNegations {
    public static void main(String[] args) {
        MaximumArraySumAFterBNegations masb = new MaximumArraySumAFterBNegations();
        int[] a = {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
        int b = 10;
        int ans = masb.maxSum(a, b);
        System.out.println(ans);
        
    }

    public int maxSum(int[] a, int b){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            minHeap.add(a[i]);
        }
        int v=0;
        while(b>0){
            v = minHeap.poll();
            if(v>=0) break;
            else{
                v=-v;
                sum+=2*v;
                minHeap.add(v);
            }
            b--;
        }
        System.out.println(b);
        if(b>0){
            if((b&1)==1){
                sum-=2*v;
            }
        }
        return sum;
    }
}
