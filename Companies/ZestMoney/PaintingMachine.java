import java.util.ArrayList;

/**
 * Given a List of strings of same length 'W' and size of list is'H', a pointer will start from 1st char of 1st string,
 * we need to paint the full 2d array.
 * find the minimum number of strokes need to paint the full picture.
 * 
 * for ex:-  
 * 
 * picture  = [ a a b b a ]
 *            [ a a b b a ]
 *            [ a a a c b ]
 * 
 * ans = 5 as    1 1 2 2 3
 *               1 1 2 2 3
 *               1 1 1 4 5
 * 
 */
import java.util.*;
public class PaintingMachine {
    public static void main(String[] args) {
        PaintingMachine pm = new PaintingMachine();

        List<String>picture = new ArrayList<>();
        picture.add("bbba");
        picture.add("abba");
        picture.add("acaaa");
        picture.add("aaac");

        int ans = pm.solve(picture);
        System.out.println(ans);
    }

    public int solve(List<String>picture){
        int h = picture.size();
        int w = picture.get(0).length();

        boolean[][] vis = new boolean[h][w];
        int[][] dp = new int[h][w];
        int count=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(!vis[i][j]){
                    count++;
                    solveUtil(i, j, dp, vis, picture, picture.get(i).charAt(j));
                }
            }
        }
        return count;
    }

    public void solveUtil(int i, int j,int[][] dp, boolean[][] vis, List<String>picture,char x){
        if(i<0||i>=dp.length||j<0||j>=dp[0].length){
            return;
        }
        if(vis[i][j]){
            return;
        }
        if(picture.get(i).charAt(j)==x){
            vis[i][j] = true;
            solveUtil(i-1, j, dp, vis, picture, x);
            solveUtil(i+1, j, dp, vis, picture, x);
            solveUtil(i, j-1, dp, vis, picture, x);
            solveUtil(i, j+1, dp, vis, picture, x);
        }else return;
    }

}
