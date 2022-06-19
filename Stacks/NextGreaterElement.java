/**
 * Given an array A, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array, A.

    More formally:

    G[i] for an element A[i] = an element A[j] such that 
        j is minimum possible AND 
        j > i AND
        A[j] > A[i]
    Elements for which no greater element exists, consider the next greater element as -1.

    sol Approach:-  the approach is similar top finding 'NearestSmaller Element' in left by using stacks.
 */
import java.util.*;
public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] a = {4, 5, 2, 10};
        int[] ans = nge.nextGreaterInRight(a);
        
        
    }

    public int[] nextGreaterInRight(int[] a){
        int n = a.length;
        int[] ans = new int[n];

        Stack<Integer>st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&a[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else ans[i] = st.peek();
            st.push(a[i]);
            System.out.println(ans[i]);
        }
        return ans;
    }
}
