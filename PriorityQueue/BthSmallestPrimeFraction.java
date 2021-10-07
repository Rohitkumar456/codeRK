import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * A sorted array of integers, A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q.

    What is the B-th smallest fraction considered?

    Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
 * 
        * Input 1:

        A = [1, 2, 3, 5]
        B = 3
        Input 2:

        A = [1, 7]
        B = 1


        Example Output
        Output 1:

        [2, 5]
        Output 2:

        [1, 7]


        Example Explanation
        Explanation 1:

        The fractions to be considered in sorted order are:
        [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
        The third fraction is 2/5.
        Explanation 2:

        The fractions to be considered in sorted order are:
        [1/7]
        The first fraction is 1/7.

 * 
 * 
 */


public class BthSmallestPrimeFraction {

    private class fraction{
        int numIndx;
        int denomIndx;

        fraction(int i, int j){
            this.numIndx = i;
            this.denomIndx = j;
        }
    }

    public static void main(String[] args) {

        BthSmallestPrimeFraction bsp = new BthSmallestPrimeFraction();
        int[] a = {1,3,5,7,11,13,17,19,23,31};
        int b = 5;

        int[] ans = bsp.getBthSmallestFraction(a, b);
        System.out.println(ans[0]+" "+ans[1]);
        
    }

    public int[] getBthSmallestFraction(int[] a, int b){
        int[] ans = new int[2];
        int n = a.length;

        PriorityQueue<fraction>minHeap = new PriorityQueue<>(new Comparator<fraction>(){
            public int compare(fraction f1,fraction f2){
                double v1 = ((double)a[f1.numIndx])/a[f1.denomIndx];
                double v2 = ((double)a[f2.numIndx])/a[f2.denomIndx];

                if(v1>v2) return 1;
                else if(v1<v2) return -1;
                else return 0;
            }
        });

        for(int i=0;i<n-1;i++){
            minHeap.add(new fraction(i, n-1));
            // System.out.println("minHeapPeek"+a[minHeap.peek().numIndx]+" "+minHeap.peek().denomIndx);
        }

        for(int i=0;i<b-1;i++){
            fraction f = minHeap.poll();
            // System.out.println("pol="+f.numIndx+" "+f.denomIndx);
            f.denomIndx--;
            if(f.numIndx<f.denomIndx){
                minHeap.add(f);
            }
        }

        fraction f = minHeap.poll();
        ans[0] = a[f.numIndx];
        ans[1] = a[f.denomIndx];


        return ans;
    }
}
