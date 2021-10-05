/**
 * 
 * There are three types of peaople living in a city X1,X2, and X3. There is a bar in the city having a compacity of A people.
 * 
 * The Barr has some strange rules
 * 
 *  1) THe bar allows atmost B people of type X3
 *  2) The bar does  not allow two consecutive entries for peolpe of type X1
 *  3) The bar does not allow Two consecutive entry for people of type X2
 * 
 * You csn assume that there are infinite people of each type in the city
 * 
 * Count the number of different ways in which A people can enter the bar. Since number of ways can be large so return ans modulo(10^9+7).
 * 
 * Constarints:-    1 <= A <= 500 
 *                  0 <= B <= 500
 * 
 * Input 1:- A = 3,B=1
 *  output = 10
 * 
 * Input 2:-  A=2, B=2
 *  output = 7
 * 
 */

public class UnusualBar {
    static long dp[][][];
    public static void main(String[] args) {
        UnusualBar ub = new UnusualBar();
        int A = 2;
        int B = 1;
        dp = new long[A+1][B+1][4];
        long ans = ub.ways(0, 0, 0, A, B);
        ans = ans%1000000007;
        System.out.println(ans);
    }

    public long ways(int total,int nB,int lastType,int A, int B){
        if(nB>B) return 0;

        if(total==A) return 1;
        if(dp[total][nB][lastType] != 0){
            return dp[total][nB][lastType];
        }

        if(lastType == 1){
            dp[total][nB][lastType] = ways(total+1, nB, 2, A, B) + ways(total+1, nB+1, 3, A, B);
            dp[total][nB][lastType]%=1000000007;
            return dp[total][nB][lastType];
        }
        else if(lastType == 2){
            dp[total][nB][lastType] =  ways(total+1, nB, 1, A, B) + ways(total+1, nB+1, 3, A, B);
            dp[total][nB][lastType]%=1000000007;
            return dp[total][nB][lastType];
        }
        else{
            dp[total][nB][lastType] = ways(total+1, nB, 1, A, B) + ways(total+1, nB, 2, A, B) + ways(total+1, nB+1, 3, A, B);
            dp[total][nB][lastType]%=1000000007;
            return dp[total][nB][lastType];
        }
    }
}
