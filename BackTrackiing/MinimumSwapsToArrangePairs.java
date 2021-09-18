
/**
 * There are A pairs and therefore 2A people. Each person has a unique number ranging from 1 to 2A. An array of integers B shows the arrangement of these 2A people.

    A matrix C of size A x 2 is given describing pairs i.e. people that are partner of each other. C[i][0] and C[i][1] are partner of each other.

    Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.
 */
import java.util.*;
public class MinimumSwapsToArrangePairs {
    int minSwap = Integer.MAX_VALUE;
    HashMap<Integer,Integer>map = new HashMap<>();
    public static void main(String[] args) {
        MinimumSwapsToArrangePairs msap = new MinimumSwapsToArrangePairs();
        
        int[][] c = {{1, 2}};
        int[]a = {1,2};
        msap.buildMap(c);
        msap.minSwaps(a, 0, 0);
        System.out.println(msap.minSwap);
    }

    public void minSwaps(int[] a, int st,int swaps){
        if(st==a.length){
            minSwap = Math.min(swaps, minSwap);
            return;
        }

        if(map.get(a[st])==a[st+1]){
            minSwaps(a, st+2, swaps);
        }else{
            int i1 = getIndex(a,map.get(a[st]));
            int i2 = getIndex(a,map.get(a[st+1]));

            swap(a,st+1,i1);
            minSwaps(a, st+2, swaps+1);
            swap(a,st+1,i1);
            swap(a,st,i2);
            minSwaps(a, st+2, swaps+1);
            swap(a, st, i2);
        }

    }

    public void swap(int[] a, int i1, int i2){
        int tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    public int getIndex(int[] a, int val){
        for(int i=0;i<a.length;i++){
            if(a[i]==val) return i;
        }
        return -1;
    }

    public void buildMap(int[][] c){
        for(int i=0;i<c.length;i++){
            map.put(c[i][0],c[i][1]);
            map.put(c[i][1],c[i][0]);
        }
    }
}
