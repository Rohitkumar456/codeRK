
/**
 * 
 * 
 */

public class MinimumCutPalindromicPartition {
    public static void main(String[] args) {
        MinimumCutPalindromicPartition mcpp = new MinimumCutPalindromicPartition();
        String s = "ab";
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        mcpp.lpsDp(s, dp);
        int ans = mcpp.solve(s, 0,n-1 , dp);
        // int ans = mcpp.minPartition(s, 0,n-1, dp);
        System.out.println(ans);
    }

    public int minPartition(String s,int start,int end,boolean[][] dp){
        if(start==s.length()) return -1;
        if(start==s.length()-1) return 0;

        if(dp[start][end]) return 0;
        String tmp = "";
        int ans = Integer.MAX_VALUE;
        for(int i=start;i<s.length();i++){
            tmp+=s.charAt(i);
            
            if(dp[start][i]){
                ans = Math.min(ans, minPartition(s, i+1,end,dp)+1);
            }
        }
        return ans;
    }

    public int solve(String s, int st, int en,boolean dp[][]){
        int n = s.length();
        int[] minCut = new int[n];
        minCut[0] = 0;
        if(s.charAt(1)==s.charAt(0)){
            minCut[1]=0;
        }else minCut[1] = 1;

        for(int i=2;i<n;i++){
            if(dp[0][i]){
                minCut[i]=0;
            }else{
                minCut[i] = 1+minCut[i-1];
                for(int j=i-1;j>0;j--){
                    if(dp[j][i]){
                        minCut[i] = Math.min(minCut[i],1+minCut[j-1]);
                    }
                }
            }
            
        }

        for(int i=0;i<n;i++){
            System.out.print(minCut[i]+" ");
        }
        return 0;
    }

    public void lpsDp(String s, boolean[][] dp){
        int n = s.length();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[i][j] = true;
                else if(i>j) dp[i][j] = false;
            }
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
            }else{
                dp[i][i+1] = false;
            }
        }

        for(int k=2;k<n;k++){
            for(int i=0,j=k;j<n;j++,i++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else dp[i][j] = false;
            }
        }

    }
}
