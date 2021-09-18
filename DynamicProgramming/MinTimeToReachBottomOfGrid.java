
/**
 * Given a grid(maze) of N*M, having doors(*) and walls(#) and (.) means nothing at tht position
 * 
 * Now,you have two types of glass, 
 *  1. you can pass throgh doors
 *  2. you can pass throgh walls
 * 
 *  you are at top left corner of the maze and you need to reach at bottom right corner of maze with 
 *  using one glass type at a time for the whole path.
 * Find the minimum time required to reach at bottom right corner of the maze using 1st and 2nd type of glass.
 * 
 * we can move in any four directions(vertically, horizontally)
 * 
 */


 
import java.util.*;

class pos{
    int i,j;
    pos(int x, int y){
        this.i = x;
        this.j = y;
    }

}
public class MinTimeToReachBottomOfGrid {
    public static void main(String[] args) {

        MinTimeToReachBottomOfGrid mtg = new MinTimeToReachBottomOfGrid();
        int n = 4;
        int m = 5;

        char[][] maze = {{'.','.','.','.','.'},
                         {'*','*','.','*','*'},
                         {'.','#','#','.','#'},
                         {'.','.','.','.','.'}};

        int[] ans = mtg.solve(maze,n,m);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public int[] solve(char[][] maze,int n, int m){
        int[] ans = new int[2];
        Queue<pos>mq = new LinkedList<>();
        pos src = new pos(0,0);

        if(maze[0][0]=='#'){
            ans[0] = -1;
        }else{
            mq.add(src);
            ans[0] = solveForGlass(maze, n, m,mq,0);
        }
        mq.clear();
        if(maze[0][0]=='*'){
            ans[1] = -1;
        }else{
            mq.add(src);
            ans[1] = solveForGlass(maze, n, m,mq,1);
        }

        return ans;
    }

    public int solveForGlass(char[][] maze,int n, int m,Queue<pos>mq,int type){
        int[][] minDist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(minDist[i], n*m);
        }
        minDist[0][0] = 0;
        vis[0][0] = true;
        int ans = 0;
        while(mq.size()!=0){
            pos cur = mq.peek();
            int x = cur.i;
            int y = cur.j;
            if(isValidForType(x,y+1,n,m,maze,vis,type)){
                minDist[x][y+1] = Math.min(minDist[x][y+1],minDist[x][y]+1);
                mq.add(new pos(x,y+1));
                vis[x][y+1] = true;
            }
            if(isValidForType(x+1,y,n,m,maze,vis,type)){
                minDist[x+1][y] = Math.min(minDist[x+1][y],minDist[x][y]+1);
                mq.add(new pos(x+1,y));
                vis[x+1][y] = true;
            }
            if(isValidForType(x,y-1,n,m,maze,vis,type)){
                minDist[x][y-1] = Math.min(minDist[x][y-1],minDist[x][y]+1);
                mq.add(new pos(x,y-1));
                vis[x][y-1] = true;
            }
            if(isValidForType(x-1,y,n,m,maze,vis,type)){
                minDist[x-1][y] = Math.min(minDist[x-1][y],minDist[x][y]+1);
                mq.add(new pos(x-1,y));
                vis[x-1][y] = true;
            }
            mq.poll();
        }
        if(minDist[n-1][m-1]!=n*m){
            return minDist[n-1][m-1];
        }else return -1;
    }

    public boolean isValidForType(int i, int j, int n, int m,char[][] maze,boolean[][] vis,int type){

        switch(type){
            case 0:{
                if(i<0||j<0||i>=n||j>=m||vis[i][j]) return false;
                else if(maze[i][j]=='#') return false;
                return true;
            }
            case 1:{
                if(i<0||j<0||i>=n||j>=m||vis[i][j]) return false;
                else if(maze[i][j]=='*') return false;
                return true;
            }
        }
        return false;
    }
}
