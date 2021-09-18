/**
 * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

    More formally,

    G[i] for an element A[i] = an element A[j] such that

    j is maximum possible AND
    j < i AND
    A[j] < A[i]

    i.e for every A[i] find the nearest smaller element in left of it;

Elements for which no smaller element exist, consider next smaller element as -1.
 */
import java.util.*;

public class NearestSmallerElement {
    public static void main(String[] args) {
        NearestSmallerElement nse = new NearestSmallerElement();
        int[]  a = {4, 5, 2, 10, 8};
        int[] ans = nse.findNse(a);
        for(int x:ans) System.out.println(x+" ");
    }

    public int[] findNse(int[] a){
        int[] ans = new int[a.length];
        Stack<Integer>st = new Stack<>();

        for(int i=0;i<a.length;i++){
            while(!st.isEmpty()&&a[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else ans[i] = st.peek();
            st.push(a[i]);
        }
        return ans;
    }
}
