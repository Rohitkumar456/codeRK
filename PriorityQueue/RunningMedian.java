import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 
 * Given an array of integers A denoting a stream of integers. New arrays of integer B and C are formed. Each time an integer is encountered in a stream, append it at the end of B and append median of array B at the C.

    Find and return the array C.

    NOTE:

    If the number of elements are N in B and N is odd then consider medain as B[N/2] ( B must be in sorted order).
    If the number of elements are N in B and N is even then consider medain as B[N/2-1]. ( B must be in sorted order).
 * 
 * 
 */

public class RunningMedian {
    ArrayList<Integer>heap = new ArrayList<>();
    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        int[] a = {69, 52, 34, 19, 56, 57, 5, 3, 83, 56};
        int[] ans = rm.getRunningMedian(a);
        for(int x:ans) System.out.println(x+" ");
    }

    public int[] getRunningMedian(int[] a){
        int[] c = new int[a.length];

        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int median = c[0] = a[0];
        maxHeap.add(a[0]);
        for(int i=1;i<a.length;i++){

            if(a[i]<=median){
                maxHeap.add(a[i]);
                if(Math.abs(maxHeap.size()-minHeap.size())>1){
                    minHeap.add(maxHeap.poll());
                }
                c[i] = maxHeap.peek();
            }else{
                minHeap.add(a[i]);
                if(minHeap.size()==maxHeap.size()){
                    c[i] = maxHeap.peek();
                }else if(Math.abs(maxHeap.size()-minHeap.size())>1){
                    maxHeap.add(minHeap.poll());
                    c[i] = maxHeap.peek();
                }else{
                    
                    c[i] = minHeap.peek();
                }
            }
            median= c[i];
        }

        return c;
    }


}
