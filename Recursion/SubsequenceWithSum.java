
/*

Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.

*/


public class SubsequenceWithSum {
    int count=0;
    public static void main(String[] args) {
        int[] A = {1,2,8};
        int B = 2;

        SubsequenceWithSum ss = new SubsequenceWithSum();
        ss.getCount(A, B, 0, 0, 0);
        System.out.println(ss.count);
    }

    public void getCount(int[] a, int b, int sum, int l, int i){
        if(l==b){
            if(sum<=1000) count++;
            return;
        }
        if(i>=a.length) return;
        getCount(a, b, sum+a[i], l+1, i+1);
        getCount(a, b, sum, l, i+1);
    }
    
}
