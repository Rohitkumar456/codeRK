


import java.util.*;


public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] a = {1,6,2,9,3,0,4,6};
        // int []a = {3,2,1};
        ms.sort(a, 0, a.length-1);
        ms.show(a);
    }

    public void sort(int[] a, int st, int end){
        if(st>=end) return;
        int mid = (st+end)/2;
        sort(a,st,mid);
        sort(a,mid+1,end);
        merge(a,st,mid,end);
    }

    public void merge(int[] a, int st,int mid,int e){
        int n1 = mid-st+1;
        int n2 = e-mid;

        int[] b = new int[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1&&j<n2){
            if(a[st+i]<=a[mid+j+1]){
                b[k++] = a[st+i];
                i++;
            }else{
                b[k++] = a[mid+j+1];
                j++;
            }
        }
        while(i<n1){
            b[k++] = a[st+i];
            i++;
        }
        while(j<n2){
            b[k++] = a[mid+j+1];
            j++;
        }
        k=0;
        for(i=st;i<=e;i++){
            a[i] = b[k++];
        }
    }

    public void show(int[] a){
        for(int x:a){
            System.out.print(x+" ");
        }
    }
}
