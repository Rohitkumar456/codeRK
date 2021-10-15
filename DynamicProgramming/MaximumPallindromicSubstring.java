
import java.util.*;
public class MaximumPallindromicSubstring {
    public static void main(String[] args) {
        MaximumPallindromicSubstring mps = new MaximumPallindromicSubstring();
        String s = "bababaabababbaababab";
        mps.solve(s);
        // int ans = mps.recursive(s, 0, s.length()-1, 0);
        // System.out.println(ans);

    }

    public void solve(String s){
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[i][j] = 1;
                else if(i>j) dp[i][j] = 0;
            }
        }

       // here we are checking for aubstring of length 2
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
            }
        }
        int st=0,en=0,max=1;

        //for substrings of length>2
        for(int k=2;k<n;k++){
            for(int i=0,j=k;j<n;j++,i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]!=0){
                        dp[i][j] = 2+dp[i+1][j-1];
                    }
                    else dp[i][j] = 0;
                }else{
                    dp[i][j] = 0;
                }
                if(max<dp[i][j]){
                    max = dp[i][j];
                    st=i;
                    en=j;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(s.substring(st,en+1)+"   len = "+(en-st+1));

    }

    public int recursive(String s, int st, int en, int count){
        if(st>en) return count;
        if(st==en) return count+1;

        if(s.charAt(st)==s.charAt(en)){
            int lcount = recursive(s, st+1, en-1, count+2);
            return Math.max(lcount, Math.max(recursive(s, st+1, en,0), recursive(s, st, en-1, 0)));
        }else{
            return Math.max(recursive(s, st+1, en, 0), recursive(s, st, en-1, 0));
        }
    }
}
