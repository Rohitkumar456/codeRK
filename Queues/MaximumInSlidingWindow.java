
/**
 * Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
 */


import java.util.*;
public class MaximumInSlidingWindow {
    public static void main(String[] args) {
        MaximumInSlidingWindow msw = new MaximumInSlidingWindow();
        int[] A = {2,10,3,4,9,1,2};
        int B = 4;
        int[] ans = msw.solve(A, B);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public int[] solve(int[] A,int B){
        int n = A.length;
        int[] ans;
        if(B>n){
            ans = new int[0];
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max = Math.max(max, A[i]);
            }
            return ans;
        }
        ans = new int[n-B+1];
        Deque<Integer>dq = new LinkedList<>();
        for(int i=0;i<B;i++){
            while(dq.size()!=0&&A[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[i]);
        }
        int j=0;
        ans[j++] = dq.getFirst();
        for(int i=B;i<n;i++){
            if(A[i-B]==dq.getFirst()){
                dq.removeFirst();
            }
            while(dq.size()!=0&&A[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[i]);
            ans[j++] = dq.getFirst();
        }

        return ans;
    }
}
