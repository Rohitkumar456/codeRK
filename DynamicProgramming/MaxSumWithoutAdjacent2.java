public class MaxSumWithoutAdjacent2 {
    public static void main(String[] args) {
        MaxSumWithoutAdjacent2 mswa = new MaxSumWithoutAdjacent2();
        int[][] a = {{1, 2, 3, 4},{2, 3, 4, 5}};
        int ans = mswa.getMax(a);
        System.out.println(ans);
    }

    public int getMax(int[][] a){
        int[] dp = new int[a[0].length+1];
        dp[0]=0;
        dp[1] = maxInBlock(a,0);
        for(int i=2;i<=a[0].length;i++){
            dp[i] = Math.max(dp[i-1],maxInBlock(a, i-1)+dp[i-2]);
        }
        return dp[a[0].length];
    }

    public int maxInBlock(int[][] a, int i){
        return Math.max(a[0][i],a[1][i]);
    }
}


