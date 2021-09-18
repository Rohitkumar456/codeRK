/**
 * Given an array of integers A .

    value of a array = max(array) - min(array).

    Calculate and return the sum of values of all possible subarrays of A % 109+7.

    SOlution Approach :- the idea is to find the contribution of every element of the array as a MAX and MIN in subarrays containing tht element.
                        i.e for every element we count all subarrays that contains the curent element as MAX or MIN
                        (this we can calculate using the idea of getting nearest smaller element from left and right for MIN and
                          nearest greater element from left and right for MAX )
 */
import java.util.*;

public class MaxMinOfAllSubarrays {
    public static void main(String[] args) {

        MaxMinOfAllSubarrays mmas = new MaxMinOfAllSubarrays();
        int[] a = {992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347};

        int ans = mmas.solve(a);
        System.out.println(ans);
        
    }


    public int solve(int[] a){
        
        int n = a.length;
        int[] max;
        int[] min;

        long ans=0;
        
        min = SubarraysAsMin(a);
        max = SubarraysAsMax(a);

        for(int i=0;i<n;i++){
            long x = max[i]-min[i];
            x=x*a[i];
            ans+=x;
            
        }
        ans = ans%1000000007;
        return (int)ans;
    }

    public int[] SubarraysAsMin(int[] a){

        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] min = new int[n];

        Stack<Integer>st = new Stack<>();
        int cnt;
        for(int i=0;i<n;i++){
            cnt=1;
            while(!st.isEmpty()&&a[i]<=a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        st.clear();

        for(int i=n-1;i>=0;i--){
            cnt=1;
            while(!st.isEmpty()&&a[i]<=a[st.peek()]){
                st.pop();
                cnt++;
            }
            if(st.isEmpty()){
                right[i] = n;
            }else{
                right[i] = st.peek();
            }
            st.push(i);
        }

        for(int i=0;i<n;i++){
            int lcount = i-left[i];
            int rcount = right[i]-i;
            min[i] = lcount*rcount;
        }
        return min;
    }

    public int[] SubarraysAsMax(int[] a){

        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] max = new int[n];

        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&a[i]>=a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&a[i]>=a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }else{
                right[i] = st.peek();
            }
            st.push(i);
        }

        for(int i=0;i<n;i++){
            int lcount = i-left[i];
            int rcount = right[i]-i;
            max[i] = lcount*rcount;
        }
        return max;
    }
}
