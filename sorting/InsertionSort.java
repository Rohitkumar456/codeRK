


import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1,5,3,7,2,9,4};
        
        InsertionSort is = new InsertionSort();
        is.sort(a);
        is.show(a);
    }

    public void sort(int[] a){
        for(int i=1;i<a.length;i++){
            int key = a[i];
            int j=i-1;
            while(j>=0&&a[j]>key){
                int t = a[j+1];
                a[j+1]=a[j];
                a[j] = t;
                j--;
            }
        }
    }

    public void show(int[] a){
        for(int x:a){
            System.out.print(x+" ");
        }
    }
}
