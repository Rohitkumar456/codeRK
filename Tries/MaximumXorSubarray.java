/**
 * Given an array A of integers of size N.
 *  Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N which has maximum XOR value.

     NOTE: If there are multiple subarrays with same maximum value, return the subarray with minimum length.
     If length is same, return the subarray with minimum starting index.


 * 
 *  
 */

import java.util.*;
public class MaximumXorSubarray {

    private class  TrieNode{
        HashMap<Integer,TrieNode>childs;
        int num;
        int indx;

        TrieNode(){
            this.childs = new HashMap<>();
        }
    }

    public static void main(String[] args) {

        MaximumXorSubarray mxs= new MaximumXorSubarray();
        int[] arr = {1, 4, 3};
        int[] ans = mxs.maxSubarrayXor(arr);
        System.out.println(ans[0]+" "+ans[1]);
        
    }

    public int[] maxSubarrayXor(int[] arr){
        int[] prefixXor = new int[arr.length+1];
        prefixXor[0] = 0;
        
        for(int i=1;i<=arr.length;i++){
            prefixXor[i] = prefixXor[i-1]^arr[i-1];
        }

        return maxXorPair(prefixXor);
    }


    public int[] maxXorPair(int[] arr){
        TrieNode root = new TrieNode();
        int n = arr.length;
        int mxor = 0;
        int[] ans = new int[2];
        TrieNode cur = root;

        //inserting the first element in the trie
        for(int bit=31;bit>=0;bit--){
            int b = (arr[0]&(1<<bit))>0?1:0;

            if(!cur.childs.containsKey(b)){
                cur.childs.put(b, new TrieNode());
            }
            cur = cur.childs.get(b);
        }
        cur.num = arr[0];
        cur.indx = 0;
        cur=root;

        for(int i=1;i<n;i++){
            cur = root;

            for(int bit=31;bit>=0;bit--){
                int b = (arr[i]&(1<<bit))>0?1:0;

                if(b==0){
                    if(cur.childs.containsKey(1)){
                        cur = cur.childs.get(1);
                    }else cur = cur.childs.get(0);
                }
                if(b==1){
                    if(cur.childs.containsKey(0)){
                        cur = cur.childs.get(0);
                    }else cur = cur.childs.get(1);
                }
            }
            int xor = cur.num^arr[i];
            if(mxor<xor){
                mxor = xor;
                ans[0] = cur.indx+1;
                ans[1] = i;
            }else if(mxor==xor){
                int cl = ans[1]-ans[0]+1;
                int len = i-cur.indx;
                if(len<cl){
                    ans[0] = cur.indx+1;
                    ans[1] = i;
                }else if(len==cl){
                    if(cur.indx+1<ans[0]){
                        ans[0] = cur.indx+1;
                        ans[1] = i;
                    }
                }
            }
            cur = root;
            for(int bit=31;bit>=0;bit--){
                int b = (arr[i]&(1<<bit))>0?1:0;

                if(!cur.childs.containsKey(b)){
                    cur.childs.put(b, new TrieNode());
                }
                cur = cur.childs.get(b);
            }
            cur.num = arr[i];
            cur.indx = i;
        }
        return ans;

    }
}
