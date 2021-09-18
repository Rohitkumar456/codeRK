/**
 * 
 */

public class LongestPallindromicSubsequence {
    int max=0;
    int [][] dp;
    public static void main(String[] args) {
        LongestPallindromicSubsequence lps = new LongestPallindromicSubsequence();
        String s = "agbdba";
        lps.getPallindromic(s,0,s.length()-1,0);
        lps.dp = new int[s.length()+1][s.length()+1];
        System.out.println(lps.max);
    }

    public void getPallindromic(String s, int st, int e,int len){
        if(st>e) return ;
        if(st==e){
            max = Math.max(max, len+1);
            // dp[st][e]
            return;
        }
        if((e-st)==1){
            max = Math.max(max, len);
            return;
        }
        if(s.charAt(st)==s.charAt(e)){
            getPallindromic(s, st+1, e-1, len+2);
        }
        getPallindromic(s, st+1, e, len);
        getPallindromic(s, st, e-1, len);
    }
}
