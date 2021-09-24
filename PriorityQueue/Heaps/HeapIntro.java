package Heaps;
/**
 * 
 * Heaps are complete binary trees, due to this property they are easy to deserialize, that is the reason
 * they are represented by the arrays and can be visualize as the trees.
 * 
 * 
 *  There are two types of the heaps :- 1) Max-Heap :- each parent is greater than its both the childs. 
 *                                      2) Min-Heap :- each parent is smaller than both the childs.
 * 
 * Array representaion having 1 based indexing , for each i :- parent  = i/2
 *                                                          :- left child = 2*i   and right child = 2*i+1 
 * 
 * 
 */

public class HeapIntro {

    public static void main(String[] args) {

        HeapIntro hi = new HeapIntro();

        int[] heap = {1};
        heap = hi.convertToHeap(heap);

        for (int i : heap) {
            System.out.println(i+" ");
        }

        MaxHeap mh  = new MaxHeap();
        mh.add(1);
        mh.add(2);
        mh.add(3);
        System.out.println(mh.remove());
    }

    public int[] convertToHeap(int[] heap){

        for(int i=heap.length/2-1;i>=0;i--){
            perculateDown_maxHeap(i, heap);
        }
        return heap;
    }

    public void perculateDown_maxHeap(int i,int[] heap){
        if(i>=heap.length) return;
        int lc = 2*i+1;
        int rc = 2*i+2;

        if(!isValid_maxHeap(i, lc, rc, heap)){
            int np = i;
            if(lc<heap.length&&heap[np]<heap[lc]) np=lc;
            if(rc<heap.length&&heap[np]<heap[rc]) np = rc;
            swap(heap, np, i);
            perculateDown_maxHeap(np, heap);
        }
    }

    public boolean isValid_maxHeap(int p,int lc, int rc, int[] heap){
        if(lc<heap.length&&heap[p]<heap[lc]) return false;
        if(rc<heap.length&&heap[p]<heap[rc]) return false;
        return true;
    }

    public void swap(int[] heap, int i, int j){
        int x = heap[i];
        heap[i] = heap[j];
        heap[j] = x;
    }
}
