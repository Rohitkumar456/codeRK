import java.util.Arrays;

public class LongesPallindromicSubsequence {
    public static void main(String[] args) {
        LongesPallindromicSubsequence lps = new LongesPallindromicSubsequence();
        String s = "abaaddaabbedeedeacbcdcaaed";  
        // int ans = lps.solveRecur(s, 0, s.length()-1);
        // int ans = lps.solveDp1util(s);
        lps.solvedp2(s);
        // System.out.println(ans);
    }
    public int solveDp1util(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solveDp1(s,0,n-1, dp);
        return ans;
    }

    public int solveDp1(String s,int i, int j,int[][] dp){
        if(i>j) return dp[i][j] = 0;
        if(i==j) return dp[i][j] = 1;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] =  2+solveDp1(s, i+1, j-1,dp);
        }else{
            return dp[i][j] =  Math.max(solveDp1(s,i+1,j,dp),solveDp1(s, i, j-1,dp));
        }
    }


    // this method is to fill the matrix diagonally, the intuition behind the approach is, when i>j we are sure that dp[i][j]=0,
    /**
     * and main diagonal elemnts constitute a pall subsequence of length 1, i.e for i==j, dp[i][j] = 1
     * Now, we will start filling up the matrix above that diagonal, for dp[i][j] = (finding lngth pallindrmic subseq for substring s(i to j) )
     * 
     * so, if s.charAt(i)==s.charAt(j), i.e it will contribute 2 to length of previous onee, i.e dp[i][j] = 2+dp[i+1][j-1];
     * else, dp[i][j] = max(dp[i,j-1],dp[i+1][j])
     * 
     * @param s
     */
    public void solvedp2(String s){
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    dp[i][j] = 1;
                }else if(i>j){
                    dp[i][j] = 0;
                }
            }
        }

        for(int k=1;k<n;k++){
            for(int i=0,j=k;j<n;i++,j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2+dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public  int solveRecur(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;

        if(s.charAt(i)==s.charAt(j)){
            return 2+solveRecur(s, i+1, j-1);
        }else{
            return Math.max(solveRecur(s,i+1,j),solveRecur(s, i, j-1));
        }
    }
}
