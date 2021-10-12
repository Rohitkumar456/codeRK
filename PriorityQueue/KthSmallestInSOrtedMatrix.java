import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 
 * Given a sorted matrix of integers A of size N x M and an integer B.

    Each of the rows and columns of matrix A are sorted in ascending order, find the Bth smallest element in the matrix.

    NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.


    SOLUTION APPROACH:- 
        we will use a min  Heap(using priority queue in java)
        now since all the roows are sorted in order so the first minimum element will be definetely from the first element of each row.

        so, we will store the first elemnt of each row in a minHeap(hence the size of minHeap will be #rows)
        then, we start, polling out from the minHeap and then we will add the next elemnt of the polled element
        ( basically next indexed element of the polled element)


        Similar approach can be used to merge any number of sorted arrays into a single one.

        TC:- 
            let total # of rows = m,
            Total # of columns = n

            therefore, Total elements = m*n;

            since we are manintainina minHeap of max size 'n' (# of rows), hence tc for building heap = n*log(n)
            tc for polling an element in minHeap = log(n)  {as size of minHeap = n} 
            and we are doing this as many times as total elements i.e m*n i.e Tc = m*n*log(n)

            Hence, total TC :-  n*log(n) + m*n*log(n)  => O(m*n*log(n)) 
 * 
 */

public class KthSmallestInSOrtedMatrix {
    private class pair{
        int i;
        int j;

        pair(int x, int y){
            this.i = x;
            this.j = y;
        }
    }
    public static void main(String[] args) {
        KthSmallestInSOrtedMatrix ksm = new KthSmallestInSOrtedMatrix();
        int[][] matrix = {{5,9,11},{9,11,13},{10,12,15},{13,14,16},{16,20,21}};
        int k = 12;
        int ans = ksm.getKthSmallest(matrix, k);
        System.out.println(ans);
    }

    public int getKthSmallest(int[][] matrix, int k){
        PriorityQueue<pair>minHeap = new PriorityQueue<>(new Comparator<pair>(){
            public int compare(pair a, pair b){
                if(matrix[a.i][a.j]>matrix[b.i][b.j]) return 1;
                else if(matrix[a.i][a.j]<matrix[b.i][b.j]) return -1;
                else return 0;
            }
        });
        
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            minHeap.offer(new pair(i,0));
        }
        pair p;
        for(int i=0;i<k-1;i++){
            p = minHeap.poll();
            p.j++;
            if(p.j<n){
                minHeap.offer(p);
            }
        }
        p = minHeap.poll();
        return matrix[p.i][p.j];
        
    }
}
