
/*

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

*/
import java.util.*;
public class SquarefulArrays {
    int count = 0;

    public static void main(String[] args) {
        SquarefulArrays sq = new SquarefulArrays();

        // int[] A = {2262, 238, 123, 21, 15, 21, 4, 60, 40, 60, 40 };
        int[]A = {1,17,8};
        int ans = sq.countSquarefulArrays(A);
        System.out.print("ans = "+ans);
    }

    public int countSquarefulArrays(int[] a){
        distinctPermute(a, 0);
        return count;
    }
    
    public boolean isPerfectSquare(long a){
        return (Math.ceil((double)Math.sqrt(a))==Math.floor((double)Math.sqrt(a)));
    }

    public void distinctPermute(int a[],int s){
        if(s==a.length-1){
            long sum = a[s]+a[s-1];
            if(isPerfectSquare(sum)){
                count++;
            }
            
            return;
        }

        for(int i=s;i<a.length;i++){
            boolean check = shouldSwap(a, s, i);
            if(check){
                swap(a,i,s);
                if(s==0 || isPerfectSquare((long)(a[s]+a[s-1]))){
                    distinctPermute(a, s+1);
                }
                swap(a, i, s);
            }
            
        }
    }

    public boolean shouldSwap(int[]a, int start, int curr){
        for (int i = start; i < curr; i++) {
            if (a[i] == a[curr]) {
                return false;
            }
        }
        
        return true;
    }

    public boolean isSquareful(int[]a){
        for(int i=0;i<a.length-1;i++){
            long sum = a[i]+a[i+1];
            if(!isPerfectSquare(sum)){
                return false;
            }
        }
        return true;
    }

    public void swap(int[]a,int i,int j){
        int t =a[i];
        a[i]=a[j];
        a[j]=t;
    }

    

    public void show(int[]a){
        System.out.print("[");
        for(int x:a){
            System.out.print(x+" ");
        }
        System.out.println("]");
    }
    
}
