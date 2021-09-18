import java.util.Map;
import java.util.TreeMap;

/**
 * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

    Return an integer corresponding to the maximum product possible.

    NOTE: Answer will fit in 32-bit integer value.

    Problem Constraints
        1 <= N <= 5 * 105

        -100 <= A[i] <= 100
 */

public class MaxSubarrayProduct {
    public static void main(String[] args) {

        MaxSubarrayProduct msp = new MaxSubarrayProduct();
        int[] a = {-4,2,-3,-1,-3,-1,3,1};
        int ans =  msp.maxP(a, 0, 1);
        System.out.println(ans);
    }

    public int maxProduct(int[] a){
        int n = a.length;
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            dp[i] = a[i];
            dp[i] = Math.max(dp[i], dp[i-1]*a[i]);
            max = Math.max(dp[i], max);
            
        }
        return max;
    }

    public int maxP(int[] a, int i, int p){
        if(i>=a.length) return p;
        System.out.println(p);
        return Math.max(maxP(a, i+1, p*a[i]),maxP(a, i+1, 1));
    }
}
