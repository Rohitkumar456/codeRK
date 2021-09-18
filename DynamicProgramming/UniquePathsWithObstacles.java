/**
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

    Now consider if some obstacles are added to the grids. How many unique paths would there be? 
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        UniquePathsWithObstacles upwo = new UniquePathsWithObstacles();
        int[][] grid = {{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        int ans = upwo.solve(grid);
        System.out.println(ans);
    }


    public int solve(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r+1][c+1];
        for(int i=0;i<r;i++){
            dp[r][0]=0;
        }
        for(int i=0;i<c;i++){
            dp[0][c]=0;
        }
        if(grid[0][0]==1) return 0;
        dp[1][1] = 1;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1&&j==1) continue;
                if(grid[i-1][j-1]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[r][c];
    }
}
