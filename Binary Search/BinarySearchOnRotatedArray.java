

import java.util.*;
public class BinarySearchOnRotatedArray {
    public static void main(String[] args) {
        BinarySearchOnRotatedArray bsr = new BinarySearchOnRotatedArray();
        int[] a = {4,5,6,1,2,3};
        int b = 7;
        // int p = bsr.pivot(a, 0, a.length-1);
        // int indx = bsr.pivotedSearch(a, b);
        int indx = bsr.rotatedBS(a, 0, a.length-1, b);
        System.out.println(indx);
        
    }

    public int rotatedBS(int[] a, int s, int e, int b){
        if(s>e) return -1;
        if(s==e) return a[s]==b?s:-1;
        
        int mid = (s+e)/2;
        if(a[mid]==b) return mid;

        if(a[mid]>=a[0]){
            if(b>=a[0]){
                if(b>a[mid]){
                    return rotatedBS(a, mid+1, e, b);
                }else{
                    return rotatedBS(a, s, mid-1, b);
                }
            }else{
                return rotatedBS(a, mid+1, e, b);
            }
        }else{
            if(b>a[0]){
                return rotatedBS(a, s, mid-1, b);
            }else{
                if(b>a[mid]){
                    return rotatedBS(a, mid+1, e, b);
                }else{
                    return rotatedBS(a, s, mid-1, b);
                }
            }
        }
    }

    public int pivotedSearch(int[]a , int b){
        int p = pivot(a, 0, a.length-1);

        if(b>=a[0]) return bs(a, 0, p-1, b);
        return bs(a, p, a.length-1, b);
    }

    public int pivot(int[]a, int s, int e){
        if(s>e) return -1;
        if(s==e) return s;
        if(s+1==e){
            return a[s]<a[e]?s:e;
        }

        int mid = (s+e)/2;
        System.out.println("start="+s+"end="+e);
        if(a[mid]<a[mid-1]&&a[mid]<a[mid+1]) return mid;
        if(a[mid]<a[0]) return pivot(a,s,mid-1);
        return pivot(a,mid+1,e);
    }

    public int bs(int[] a, int s, int e, int b){
        if(s>e) return -1;
        if(s==e) return a[s]==b?s:-1;
        
        int mid = (s+e)/2;
        if(a[mid]==b) return mid;
        if(a[mid]>b) return bs(a,s,mid-1,b);
        return bs(a,mid+1,e,b);
    }
}
