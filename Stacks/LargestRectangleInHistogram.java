import java.util.*;

/**
 * Given an array of integers A .

    A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.

    Find the area of the largest rectangle formed by the histogram.

    solution approach :-   the idea is to find the contribution of each element in any histogram.
                    i.e for each bar of histogram we will count till we get a bar of length just less than the current in left
                    i.e for every index(i) we will store the index of element which is smaller in left(j), therefore, count = j-i;
                     here, we will use the approach to find "NearestSmaller element in left and right", this will give us the contribution of each bar respectively
 */

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();

        int[] a = {8,1,6,2,7,4,3,5};
        int ans = lrh.solve(a);
        System.out.println(ans);
    }

    public int solve(int[] arr){
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
