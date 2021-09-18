

import java.util.*;
public class NumberOfSubArraysWithUniqueElements {
    public static void main(String[] args) {
        NumberOfSubArraysWithUniqueElements nsue = new NumberOfSubArraysWithUniqueElements();
        int[] a = {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
        // int[]a = {1,2,3,4,3,6,7};
        nsue.solve(a);
    }

    public void solve(int[] a){
        long ans = 0;
        // ans+=a.length;
        int s=0,l=0,cnt=0,e=0;
        HashMap<Integer,Integer>hm = new HashMap<>();
        while(l<a.length){

            if(hm.containsKey(a[l])){
                s=hm.get(a[l])+1;
                hm.clear();
                for(int i=s;i<l;i++){
                    hm.put(a[i], i);
                }
            }else{
                hm.put(a[l],l);
                ans+=l-s+1;
                l++;
            }
        }
        System.out.println(ans);
    }
}
