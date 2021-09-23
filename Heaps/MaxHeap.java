import java.util.ArrayList;

public class MaxHeap implements Heap{
    
    private ArrayList<Integer>heapArr;

    MaxHeap(){
        this.heapArr = new ArrayList<>();
    }

    public void maxHeapify(){
        int n = this.heapArr.size();
        for(int i=n/2-1;i>=0;i--){
            perculateDown(i);
        }
    }

    public void perculateDown(int indx){
        int leftChild = 2*indx+1;
        int rightChild = 2*indx+2;
        
        if(!isValidMaxHeap(indx,leftChild,rightChild)){
            int nonValidChild = indx;
            if(leftChild<heapArr.size()&&heapArr.get(leftChild)>heapArr.get(nonValidChild)) nonValidChild = leftChild;

            if(rightChild<heapArr.size()&&heapArr.get(rightChild)>heapArr.get(nonValidChild)) nonValidChild = rightChild;

            perculateDown(nonValidChild);
        }
    }

    public void perculateUp(int cur){
        int parent = (cur+1)/2;
        if(parent>=0 && heapArr.get(parent)<heapArr.get(cur)){
            swap(cur, parent);
            perculateUp(parent);
        }
    }

    public boolean isValidMaxHeap(int cur, int left, int right){
        if(left<heapArr.size()&&heapArr.get(cur)<heapArr.get(left)) return false;
        if(right<heapArr.size()&&heapArr.get(cur)<heapArr.get(right)) return false;
        return true;
    }

    public void swap(int i, int j){
        int t = heapArr.get(i);
        heapArr.set(i, heapArr.get(j));
        heapArr.set(j, t);
    }
}
