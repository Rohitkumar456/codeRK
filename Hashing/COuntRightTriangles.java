import java.util.*;

/**
 * 
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

    Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

    NOTE: The answer may be large so return the answer modulo (109 + 7).
 * 
 */

public class COuntRightTriangles {
    public static void main(String[] args) {
        COuntRightTriangles crt = new COuntRightTriangles();
        int[] x = {1, 1, 2, 3, 3};
        int[] y = {1, 2, 1, 2, 1};
        int ans = crt.count(x, y);
        System.out.println(ans);
    }


    public int count(int[] x, int[] y){
        int ans = 0;
        HashMap<Integer,Integer>xPoints = new HashMap<>();
        HashMap<Integer,Integer>yPoints = new HashMap<>();

        for(int i=0;i<x.length;i++){
            xPoints.put(x[i],xPoints.getOrDefault(x[i],0)+1);
            yPoints.put(y[i],yPoints.getOrDefault(y[i],0)+1);
        }

        for(int i=0;i<x.length;i++){
            ans+=(xPoints.get(x[i])-1)*(yPoints.get(y[i])-1);
        }

        return ans;
    }
}
