

import java.util.*;
public class LongestCommonSubsequence {
    int max = -1;
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "abcdge";
        String b = "dgede";
        // lcs.recursive(a, b, a.length()-1, b.length()-1, 0);
        
        // int ans = lcs.dpSolution(a, b);
        int ans = lcs.recursiveFromLast(a, b, a.length()-1, b.length()-1);
        System.out.println(ans);
    }

    public int dpSolution(String a, String b){
        int n1 = a.length();
        int n2 = b.length();
        int max = -1;
        int[][] dp = new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n2;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


    public void recursive(String a, String b, int m , int n,int len){
        if(m<0||n<0){
            max = Math.max(max,len);
            return;
        }

        if(a.charAt(m)==b.charAt(n)){
            recursive(a, b, m-1, n-1, len+1);
        }else{
            recursive(a, b, m-1, n, len);
            recursive(a, b, m, n-1, len);
        }
    }

    public int recursiveFromLast(String a, String b, int i, int j){
        System.out.println("indices are:- "+i+" "+j);
        if(i<0||j<0) return 0;
        if(i==0&&j==0){
            return a.charAt(i)==b.charAt(j)?1:0;
        }

        if(a.charAt(i)==b.charAt(j)){
            return 1+recursiveFromLast(a, b, i-1, j-1);
        }else{
            return Math.max(recursiveFromLast(a, b, i-1, j), recursiveFromLast(a, b, i, j-1));
        }
    }

}
