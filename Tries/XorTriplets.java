/**
 * Given an array of integers A of size N.

    A triplet (i, j, k), i <= j <= k is called a power triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].

    Where, ^ denotes bitwise xor.

    Return the count of all possible power triplets. Since the answer could be large return answer % 109 +7.

    804, 621, 170, 320, 234, 81, 57, 175, 513, 189, 163, 610, 656, 52, 957, 632, 33, 920, 280, 317, 931, 848, 630, 511, 251, 754, 899, 648, 284, 598, 818, 428, 18, 996, 629, 203, 449, 925, 25, 961, 451, 80, 625, 284, 945, 190, 650, 501, 265, 56, 919, 803, 762, 514, 973, 564, 356, 775, 538, 550, 755, 903, 106, 365, 230, 174, 882, 918, 290, 775, 169, 251, 477, 49, 107, 967, 368, 432, 272, 5, 556, 223, 460, 812, 848, 853, 513, 470, 833, 966, 786, 641, 916, 892, 448, 973, 488, 669, 819, 687 
 * 
 * 
 * 
 * 
 * SolutionApproach:- 
 *  the main logic here is that, for a triplet [i,j,k],
 *   if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k]  => A[i]^A[i+1]^...A[j]^A[j+1]^...A[k]=0
 *      and also, for every j>i and j<=k, will make a power triplet. for ex:- if i=2 and k=5 then, total triplets = k-i-1
 * 
 *  hence, if we calculate the prefix xor of the array then , all repeating values values means a subarray having cumulative xor value = 0.
 *          
 * 
 * 
 * 
 */

import java.util.*;
public class XorTriplets {
    public static void main(String[] args) {
        XorTriplets xt = new XorTriplets();
        // int[] a = {804, 621, 170, 320, 234, 81, 57, 175, 513, 189, 163, 610, 656, 52, 957, 632, 33, 920, 280, 317, 931, 848, 630, 511, 251, 754, 899, 648, 284, 598, 818, 428, 18, 996, 629, 203, 449, 925};
        // int[]a = {5,2,7};
        int[] a = {804, 621, 170, 320, 234, 81, 57, 175, 513, 189, 163, 610, 656, 52, 957, 632, 33, 920, 280, 317, 931, 848, 630, 511, 251, 754, 899, 648, 284, 598, 818, 428, 18, 996, 629, 203, 449, 925, 25, 961, 451, 80, 625, 284, 945, 190, 650, 501, 265, 56, 919, 803, 762, 514, 973, 564, 356, 775, 538, 550, 755, 903, 106, 365, 230, 174, 882, 918, 290, 775, 169, 251, 477, 49, 107, 967, 368, 432, 272, 5, 556, 223, 460, 812, 848, 853, 513, 470, 833, 966, 786, 641, 916, 892, 448, 973, 488, 669, 819, 687};
        int ans = xt.getTriplet(a);
        System.out.println("ans="+ans);
    }

    public int getTriplet(int[] a){
        long ans = 0;
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        
        int[] preXor = new int[a.length+1];
        preXor[0] = 0;
        for(int i=0;i<a.length;i++){
            preXor[i+1] = preXor[i]^a[i];
        }
        ArrayList<Integer>tmp;
        for(int i=0;i<preXor.length;i++){
            
            if(!map.containsKey(preXor[i])){
                tmp = new ArrayList<>();
                tmp.add(i);
                map.put(preXor[i],tmp);
            }else{
                tmp = map.get(preXor[i]);
                for(int x:tmp){
                    ans+=(i-x)-1;
                }
                tmp.add(i);
                map.put(preXor[i], tmp);
            }
        }
        ans = ans%1000000007;
        return (int)ans;
        
    }
}
