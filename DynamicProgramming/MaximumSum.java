/**
 * 
 * 
 * You are given an array A of N integers and three integers B, C, and D.

    You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
 * 
 * 
 */




public class MaximumSum {
    int[][][] dp;
    public static void main(String[] args) {
        MaximumSum ms = new MaximumSum();
        int[] a = {1,5,-3,4,-2};
        int b = 2,c = 1,d = -1;
        ms.dp = new int[a.length][a.length][a.length];
        int ans = ms.getSUm(a, b, c, d);
        System.out.println(ans);
    }

    public int getSUm(int[]a,int b, int c, int d){
        int[] maxAi_B = new int[a.length];
        maxAi_B[0] = a[0]*b;
        for(int i=1;i<a.length;i++){
            maxAi_B[i] = Math.max(maxAi_B[i-1], a[i]*b);
        }

        int[] maxAj_C = new int[a.length];
        maxAj_C[0] = maxAi_B[0]+a[0]*c;

        for(int i=1;i<a.length;i++){
            maxAj_C[i] = Math.max(maxAj_C[i-1], a[i]*c+maxAi_B[i]);
        }

        int[] maxAk_D = new int[a.length];
        maxAk_D[0] = maxAj_C[0]+a[0]*d;

        for(int i=1;i<a.length;i++){
            maxAk_D[i] = Math.max(maxAk_D[i-1], a[i]*d+maxAj_C[i]);
        }

        return maxAk_D[a.length-1];
    }
}
