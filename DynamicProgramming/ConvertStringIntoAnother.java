
/**
 * 
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
 */

public class ConvertStringIntoAnother {
    int [][] dp;
    public static void main(String[] args) {
        ConvertStringIntoAnother csia = new ConvertStringIntoAnother();
        String a = "abaabbbbaaabba";
        String b = "aaaababa";
        csia.dp = new int[a.length()][b.length()];
        int ans = csia.solve(a,b,0,0);
        System.out.println(ans);
    }



    public int solve(String A, String B,int i, int j){
        if(i==A.length()&&j==B.length()){
            return 0;
        }
        if(i==A.length()){
            return B.length()-j;
        }else if(j==B.length()){
            return A.length()-i;
        }
         
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        
        if(A.charAt(i)==B.charAt(j)){
            return dp[i][j] =  solve(A, B, i+1, j+1);
        }else{
            int x = 1+solve(A, B, i+1, j+1);
            int y = 1+solve(A, B, i+1, j);
            int z = 1+solve(A, B, i, j+1);
            return dp[i][j] =  Math.min(z,Math.min(x,y));
        }
            
    }
}
