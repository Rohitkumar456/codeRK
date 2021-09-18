import java.util.*;

/**
 * Given an array A of both positive and negative integers.

    Your task is to compute sum of minimum and maximum elements of all sub-array of size B.

    NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 */

public class SumOfMaxMinOfSubarrays {
    public static void main(String[] args) {
        SumOfMaxMinOfSubarrays soms = new SumOfMaxMinOfSubarrays();
        int[] a = {2, 5, -1, 7, -3, -1, -2};
        int b=3;
        long sum = soms.getSum(a, b);
        System.out.println(sum);
        
    }

    public long getSum(int[] a, int b){
        long maxsum = 0;
        long minSum = 0;
        int n = a.length;
        Deque<Integer>maxdq = new LinkedList<>();
        Deque<Integer>mindq = new LinkedList<>();

        for(int i=0;i<b;i++){
            while(!maxdq.isEmpty()&&a[i]>=maxdq.getLast()){
                maxdq.removeLast();
            }
            maxdq.addLast(a[i]);
        }

        for(int i=0;i<b;i++){
            while(!mindq.isEmpty()&&a[i]<=mindq.getLast()){
                mindq.removeLast();
            }
            mindq.addLast(a[i]);
        }

        maxsum+=maxdq.getFirst();
        minSum+=mindq.getFirst();
        for(int i=b;i<n;i++){
            if(a[i-b]==maxdq.getFirst()){
                maxdq.removeFirst();
            }
            while(!maxdq.isEmpty()&&a[i]>=maxdq.getLast()){
                maxdq.removeLast();
            }
            maxdq.addLast(a[i]);
            maxsum+=maxdq.getFirst();
        }

        for(int i=b;i<n;i++){
            if(a[i-b]==mindq.getFirst()){
                mindq.removeFirst();
            }
            while(!mindq.isEmpty()&&a[i]<=mindq.getLast()){
                mindq.removeLast();
            }
            mindq.addLast(a[i]);
            minSum+=mindq.getFirst();
        }


        return maxsum+minSum;

    }
}
