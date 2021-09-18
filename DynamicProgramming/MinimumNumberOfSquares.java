


import java.util.*;


public class MinimumNumberOfSquares {
    int[] dp;
    public static void main(String[] args) {
        MinimumNumberOfSquares mns = new MinimumNumberOfSquares();
        int n = 97280;
        mns.dp = new int[n+1];
        int ans = mns.getMin(n);
        // System.out.println(ans);
        for(int x:mns.dp){
            System.out.println(x);
        }
    }

    public int getMin(int n){
        if(n==1) return dp[n] = 1;
        if(dp[n]!=0) return dp[n];
        if(isPerfectSquare(n)) {
            dp[n] = 1;
            return 1;
        }

        int s = (int)Math.sqrt(n);
        dp[n] = Integer.MAX_VALUE;
        for(int i=s;i>=1;i--){
            dp[n] = Math.min(1+getMin(n-i*i),dp[n]);
        }
        return dp[n];
        
    }

    public boolean isPerfectSquare(int n){
        int s = (int)Math.sqrt(n);
        return n == s*s;
    }
}
