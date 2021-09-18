public class WaysOfPartying {
    public static void main(String[] args) {
        WaysOfPartying wop = new WaysOfPartying();

        int n = 465;
        int ans = wop.solve(n);
        System.out.println(ans);
    }

    public int solve(int A){
        long dp[] = new long[A+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=A;i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
            dp[i]%=10003;
            System.out.println(dp[i]);
        }
        long ans = dp[A]%10003;
        return (int)ans;
    }
}
