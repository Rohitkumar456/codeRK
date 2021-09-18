// Given an array of integers A and an integer B, find and return the maximum value K 
//such that there is no subarray in A of size K with sum of elements greater than B.



public class SpecialInteger {

    public static void main(String[] args) {
        int A[] = {5,17,100,11};
        int B = 130;

        System.out.println(solve(A,B));
    }

    public static int solve(int A[],int B){
        int n = A.length;
        int l=1,h=n;
        int ans=0;
        while(l<=h){
            int mid = (l+h)/2;

            if(isPossible(A,mid,B)){
                ans = mid;
                l=mid+1;
            }else h=mid-1;
        }
        return ans;
    }

    public static boolean isPossible(int a[], int mid, int b){
        int i=0,j=0;
        long sum = 0;
        while(j<mid) sum+=a[j++];
        if(sum>b) return false;

        while(j<a.length){
            sum+=a[j++];
            sum-=a[i++];
            if(sum>b) return false;
        }
        return true;
    }


    
}
