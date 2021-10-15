/**
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
 * 
 * 
 */

public class WaysToDecode {
    public static void main(String[] args) {
        WaysToDecode wtd = new WaysToDecode();
        String msg = "2611055971756562";
        int ans =  wtd.waystoDecodeDp(msg);  
        System.out.println(ans);
    }

    public int waystoDecodeDp(String msg){
        int mod = 1000000007;
        int n = msg.length();
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        if(msg.charAt(0)=='0') return 0;
        for(int i=2;i<=n;i++){
            int cur = msg.charAt(i-1)-'0';
            int prev = msg.charAt(i-2)-'0';
            int num = prev*10+cur;

            if(cur>0&&prev>0&&num>=1&&num<=26){
                dp[i] = dp[i-1]+dp[i-2];
            }else if(cur==0&&num>=1&&num<=26){
                dp[i] = dp[i-2];
            }else if(cur>0&&prev==0){
                dp[i] = dp[i-1];
            }else if(cur>0&&num>26){
                dp[i] = dp[i-1];
            }else{
                return 0;
            }
            dp[i] = dp[i]%mod;
        }
        return (int)dp[n];
    }
}
