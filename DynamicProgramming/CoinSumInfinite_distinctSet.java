
/**
 * You are given a set of coins A. In how many ways(order is not important i.e {1,2} and {2,1} are same) 
 * can you make sum B assuming you have infinite amount of each coin in the set.

    NOTE:

    Coins in set A will be unique. Expected space complexity of this problem is O(B).
    The answer can overflow. So, return the answer % (106 + 7).

    for ex:- a = {1,2,3}, sum = 4   =>    ways(#4) = {1,1,1,1},{1,1,2},{1,3},{2,2}
 */
import java.util.*;
public class CoinSumInfinite_distinctSet {
    public static void main(String[] args) {
        
        CoinSumInfinite_distinctSet csiD = new CoinSumInfinite_distinctSet();
        int[] a = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
        int sum = 458;
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);
        long ans = csiD.solve(a, sum);
        System.out.println(ans%1000007);
    }


    public long solve(int[]a, int sum){
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for(int i=0;i<a.length;i++){
            for(int j=a[i];j<=sum;j++){
                dp[j] = dp[j]+dp[j-a[i]];
            }
        }
        return dp[sum];
    }
    
}
