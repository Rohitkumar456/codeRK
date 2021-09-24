

/**
 * 
 * Given an array of integers A. Find and return the number of subarrays whose xor values is less than B.
   NOTE: As the answer can be very large, return the answer modulo (10^9+7).
 * 
 */

import java.util.*;

public class SubarraysXorLessThanB {

    private class TrieNode{
        int cnt;
        HashMap<Integer,TrieNode>childs;
        int num;
        boolean isEnd;

        TrieNode(){
            this.childs = new HashMap<>();
            this.cnt = 0;
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {

        SubarraysXorLessThanB sxb = new SubarraysXorLessThanB();
        // int arr[] = {8,3,10,2,6,7,6,9,3};
        int arr[] = {9,4,3,11};
        int B = 7;
        int ans = sxb.countSubarrysXorSumLessThanB(arr, B);
        System.out.println(ans);
    }

    public int countSubarrysXorSumLessThanB(int arr[],int B){
        TrieNode root = new TrieNode();
        int[] pxor = new int[arr.length+1];
        long ans = 0;
        
        pxor[0] = 0;
        for(int i=0;i<arr.length;i++){
            pxor[i+1] = pxor[i]^arr[i];
            // System.out.print(pxor[i+1]+" ");
        }

        insertAsBits(root, 0);
        TrieNode cur;
        for(int i=1;i<pxor.length;i++){
            cur = root;
            for(int bit=31;bit>=0;bit--){
                int numBit = (pxor[i]&(1<<bit))>0 ? 1: 0;
                int bBit = (B&(1<<bit))>0?1:0;

                if(bBit == 0){
                    if(numBit == 1){
                        if(cur.childs.containsKey(1)){
                            cur = cur.childs.get(1);
                        }else break;
                    }else{
                        if(cur.childs.containsKey(0)){
                            cur = cur.childs.get(0);
                        }else break;
                    }
                }else{
                    if(numBit==1){
                        if(cur.childs.containsKey(1)){
                            // System.out.println("rohit "+pxor[i]);
                            ans+=cur.childs.get(1).cnt;
                        }
                        if(cur.childs.containsKey(0)){
                            cur = cur.childs.get(0);
                        }else break;
                    }
                    else{
                        if(cur.childs.containsKey(0)){
                            // System.out.println("rohit "+pxor[i]);
                            ans+=cur.childs.get(0).cnt;
                        }
                        if(cur.childs.containsKey(1)){
                            cur = cur.childs.get(1);
                        }else break;
                    }
                }
            }
            if(cur.isEnd){
                if((cur.num^pxor[i])<B) ans++;
            }
            insertAsBits(root, pxor[i]);

        }
        return (int)ans;



        
    }

    public void insertAsBits(TrieNode root, int val){
        TrieNode cur = root;
        for(int i=31;i>=0;i--){
            int b = (val&(1<<i))>0 ? 1 : 0;
            if(!cur.childs.containsKey(b)){
                cur.childs.put(b, new TrieNode());
            }
            cur = cur.childs.get(b);
            cur.cnt++;
        }
        cur.num = val;
        cur.isEnd = true;
    }
}
