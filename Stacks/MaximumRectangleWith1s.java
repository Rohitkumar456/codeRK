/**
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

    Find the largest rectangle containing only 1's and return its area.

    Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
import java.util.*;
public class MaximumRectangleWith1s {
    public static void main(String[] args) {
        MaximumRectangleWith1s mr = new MaximumRectangleWith1s();
        int[][] a = {{0,0,1},{0,1,1},{1,1,1}};
        int ans = mr.solve(a);
        System.out.println(ans);
    }

    public int solve(int[][] rect){
        int maxArea = -1;
        int row = rect.length;
        int col = rect[0].length;

        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(rect[i][j]==1){
                    rect[i][j] = rect[i-1][j]+1;
                }
            }
        }

        for(int i=0;i<row;i++){
            maxArea = Math.max(maxArea, getArea(rect[i]));
        }

        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(rect[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return maxArea;
    }

    public int getArea(int[] arr){
        int n = arr.length;
        int[] leftSmaller = new int[arr.length];
        int[] rightSmaller = new int[arr.length];

        Stack<Integer>st = new Stack<>();
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            cnt = 1;
            while(!st.isEmpty()&&arr[i]<=arr[st.peek()]){
                st.pop();
                cnt++;
            }
            if(st.isEmpty()){
                leftSmaller[i] = -1;                 // i.e. all elemets are greater int left of the cur elemnt
            }else{
                leftSmaller[i] = st.peek();
            }
            
            st.push(i);
            // System.out.print(leftSmaller[i]+" ");
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            cnt=1;
            while(!st.isEmpty()&&arr[i]<=arr[st.peek()]){
                st.pop();
                cnt++;
            }
            if(st.isEmpty()){
                rightSmaller[i] = n;                    // i.e all elements in right are greater than the cur element
            }else{
                rightSmaller[i] = st.peek();
            }
            
            st.push(i);
            // System.out.print(rightSmaller[i]+" ");
        }

        int maxArea = -1;

        for(int i=0;i<n;i++){
            int lc = i-leftSmaller[i];
            int rc = rightSmaller[i]-i;    // -1 is bcs we have considered the same bar as twice, hence need to subtract 1 in final while calculating leftsmaller and right smaller;
            maxArea = Math.max(maxArea,arr[i]*(lc+rc-1));
        }

        return maxArea;

    }
}
