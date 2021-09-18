/**
 * Given an array of integers of length N, find the length of longest increasing(strictly) subsequence of the array
 */
import java.util.*;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] a ={6,6, 9, 7, 3, 5, 1, 7, 10};
        int ans = lis.getLengthLIS(a);
        System.out.println(ans);
    }


    // this is the DP solution whoose TC:o(n2) and SC:o(n)

    public int getLIS(int[] a){                 
        int lis[] = new int[a.length];
        int maxL = -1;
        for(int i=0;i<a.length;i++){
            lis[i] = 1;
            int j=i-1;
            while(j>=0){
                if(a[i]>a[j]){
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
                j--;
            }
            maxL = Math.max(maxL, lis[i]);
        }
        return maxL;
    }


    //this is the binary search approach with tc: o(n logn)
    public int getLengthLIS(int[] a){
        int n = a.length;
        int[] tmp = new int[n+1];
        int llis=1;
        tmp[1] = a[0];
        for(int i=1;i<n;i++){
            int indx = bsearchIndex(tmp,1,llis,a[i]);
            if(indx==-1){
                if(a[i]<tmp[1]) tmp[1]=a[i];
            }else{
                llis=Math.max(llis, indx+1);
                tmp[indx+1]=a[i];
            }
        }
        return llis;
    }

    public int bsearchIndex(int[] tmp,int l, int h, int val){
        int indx=-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(tmp[mid]<val){
                indx = mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return indx;
    }
}
