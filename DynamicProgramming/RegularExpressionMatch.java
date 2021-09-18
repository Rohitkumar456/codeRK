import java.util.Arrays;


/**
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
        The matching should cover the entire input string (not partial).
 */

public class RegularExpressionMatch {
    int[][] dp;
    public static void main(String[] args) {
        RegularExpressionMatch rem = new RegularExpressionMatch();
        String A = "bac";
        String B = "b*";
        int n = A.length();
        int m = B.length();

        rem.dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(rem.dp[i], -1);
        }
        boolean ans = rem.matchRecur(A, B, 0, 0);
        // int ans = rem.matchDP(A, B, 0, 0);
        System.out.println(ans);

        
    }

    public int matchDP(String a, String b, int i, int j){
        
        return 0;
    }


    public boolean matchRecur(String a,String b, int i, int j){
        if(i==a.length()&&j==b.length()){
            return true;
        }else if(j==b.length()){
            return true;
        }else if(i==a.length()){
            return false;
        }

        if(a.charAt(i)==b.charAt(j)){
            return matchRecur(a, b, i+1, j+1);
        }else if(b.charAt(j)=='?'){
            return matchRecur(a, b, i+1, j+1);
        }else if(b.charAt(j)=='*'){
            return matchRecur(a, b, i+1, j) || matchRecur(a, b, i, j+1);
        }
        return false;

    }
}
