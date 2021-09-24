package Heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        int parent = (cur+1)/2-1;
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

    @Override
    public boolean add(int newVal) {
        // TODO Auto-generated method stub
        this.heapArr.add(newVal);
        perculateUp(heapArr.size()-1);
        return true;
    }

    @Override
    public int peek() {
        if(heapArr.size()>0){
            return heapArr.get(0);
        }else throw new NoSuchElementException();
    }

    @Override
    public int remove() {
        int val = heapArr.get(0);
        swap(0, heapArr.get(heapArr.size()-1));
        heapArr.remove(heapArr.size()-1);
        perculateDown(0);
        return val;
    }
}
