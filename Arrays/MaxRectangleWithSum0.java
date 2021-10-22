
import java.util.*;
public class MaxRectangleWithSum0 {
    static class task{
        int i;
    }
    public static void main(String[] args) {
        MaxRectangleWithSum0 mrs = new MaxRectangleWithSum0();
        int[][] rectangle = {{1,2,3},{-3,-2,-1},{1,2,3}};
        int ans = mrs.getMaxrectangle(rectangle);
    }

    public static void tmp(){
        
    }


    public int getMaxrectangle(int[][] rectangle){
        int r = rectangle.length;
        int c = rectangle[0].length;
        int[][] dp = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int s1 = (i-1)>=0?dp[i-1][j]:0;
                int s2 = (j-1)>=0?dp[i][j-1]:0;
                int s3 = ((i-1)>=0&&(j-1)>=0)?dp[i-1][j-1]:0;
                dp[i][j] = rectangle[i][j] + s1 + (s2 - s3);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
        
    }
}
