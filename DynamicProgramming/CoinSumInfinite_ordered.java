import java.util.Arrays;

/**
 * You are given a set of coins A. In how many ways(order is important i.e {1,2} and {2,1} are different) 
 * can you make sum B assuming you have infinite amount of each coin in the set.

    NOTE:

    Coins in set A will be unique. Expected space complexity of this problem is O(B).
    The answer can overflow. So, return the answer % (106 + 7).

    for ex:- a = {1,2,3}, sum = 4   =>    ways(#7) = {1,1,1,1},{1,1,2},{1,2,1},{2,1,1},{1,3},{3,1},{2,2}
 */

 import java.util.*;
public class CoinSumInfinite_ordered {
    public static void main(String[] args) {
        CoinSumInfinite_ordered csi = new CoinSumInfinite_ordered();
        int[] a = {1,2,3};
        int sum = 4;
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);
        int ans = csi.solveRecursion(sum, a, dp);
        // int ans = csi.solveIterative(sum, a);
        System.out.println(ans);
    }

    public int solveIterative(int sum, int[]a){
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i=1;i<=sum;i++){
            int ans = 0;
            for(int j=0;j<a.length;j++){
                if(a[j]<=i){
                    ans+=dp[i-a[j]];
                }
            }
            dp[i] = ans;
        }
        return dp[sum];
    }

    public int solveRecursion(int sum,int[] a,int[] dp){
        if(sum==0) return 1;
        if(dp[sum]!=-1) return dp[sum];

        int ans=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=sum){
                ans+=solveRecursion(sum-a[i], a, dp);
            }
        }
        return dp[sum] = ans;
    }

    
}
