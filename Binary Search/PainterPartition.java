/*

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.

*/


import java.util.*;
public class PainterPartition {
    public static void main(String[] args) {
        
        int A = 10,B = 1;
        int C[] = {1,8,11,3};
        PainterPartition p = new PainterPartition();
        System.out.println(p.paint(A, B, C));
    }


    public int paint(int A, int B, int C[]){
        int n = C.length;
        int l=-1,h=0;
        for(int i=0;i<n;i++){
            l = Math.max(l,C[i]);
            h+=C[i];
        }
        long ans = 0;
        int mod = 10000003;
        while(l<=h){
            int mid = (l+h)/2;

            if(isPossible(A,C,mid)){
                ans = mid;
                h=mid-1;
            }else l=mid+1;
        }
        ans = ans*B;
        ans = ans%mod;
        return (int)ans;
    }

    public boolean isPossible(int np, int c[],int mid){
        int sum=0;
        int n = c.length;
        int p=1;
        for(int i=0;i<n;i++){
            if(c[i]>mid) return false;
            sum+=c[i];
            if(sum>mid){
                sum=c[i];
                p++;
            } 
        }
        return (p<=np)?true:false;
    }

}
