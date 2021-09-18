
/*

Given an Array of size N, we have to find all the permutaions of the array

*/



import java.util.*;
public class PermutationsOfArray {
    ArrayList<ArrayList<Integer>>permutations = new ArrayList<>();
    public static void main(String[] args) {
        
        int[] a ={0,0,0,1,1};
        PermutationsOfArray poa = new PermutationsOfArray();
        poa.distinctPermute(a,0);
        poa.show();
    }

    public void permute(int[] a, int s, int e){
        if(s==e){
            ArrayList<Integer>tmp = new ArrayList<>();
            for(int x:a){
                tmp.add(x);
            }
            permutations.add(tmp);
            return;
        }

        for(int i=s;i<=e;i++){
            swap(a,i,s);
            permute(a, s+1, e);
            swap(a, i, s);
        }
    }

    public void distinctPermute(int a[],int s){
        if(s==a.length-1){
            ArrayList<Integer>tmp = new ArrayList<>();
            for(int x:a){
                tmp.add(x);
            }
            permutations.add(tmp);
            return;
        }

        for(int i=s;i<a.length;i++){
            boolean check = shouldSwap(a, s, i);                    // function which will tell weather we need to swap or not
            if(check){
                swap(a,i,s);
                distinctPermute(a, s+1);
                swap(a, i, s);
            }
            
        }
    }

    public void swap(int[]a,int i, int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public void show(){
        for(ArrayList<Integer>tmp:permutations){
            System.out.print("[ ");
            for(int x:tmp){
                System.out.print(x+" ");
            }
            System.out.println("]");
        }
    }

    public boolean shouldSwap(int[]a, int start, int curr){             // 'start' and 'curr' are the indices which we want to swap, 
        for (int i = start; i < curr; i++) {                            // we will iterarte from 'start' to 'curr' and check that if we have already encountered the 
            if (a[i] == a[curr]) {                                      // number same as 'curr' and we return false if it was found (i.e we have alredy generated the permutation for that swap and no need to do that again)
                return false;                                           // this will just restrict us to generate similar permutations
            }
        }
        return true;
    }
    
}
