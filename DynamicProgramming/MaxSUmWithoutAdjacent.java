
/**
 * Given an Array of integers , You need to find the maximum sum that i can get such that ,
 *  no two adjacent element taken/added to the sum.
 */


import java.util.*;
public class MaxSUmWithoutAdjacent {
    public static void main(String[] args) {
        MaxSUmWithoutAdjacent mswa = new MaxSUmWithoutAdjacent();
        int[] a = {2,7,9,3,1};
        int ans = mswa.maxSum(a);
        System.out.println(ans);
    }

    public int maxSum(int[] a){
        int[] dp = new int[a.length+1];
        dp[0] = 0;
        dp[1] = a[0];
        for(int i=2;i<=a.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+a[i-1]);
        }
        return dp[a.length];
    }
}
