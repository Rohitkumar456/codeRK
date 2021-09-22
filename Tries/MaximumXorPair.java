
/**
 * 
 * 
    Given an array of integers A, 
    find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array
 */
import java.util.*;

public class MaximumXorPair {

    private class TrieNode{
        HashMap<Integer,TrieNode>childs;
        boolean isEnd;
        int num;

        TrieNode(){
            this.childs = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        MaximumXorPair mxp = new MaximumXorPair();
        int[] arr = {5,2,3,4};
        int ans = mxp.maxXor(arr);
        System.out.println(ans);
        
    }

    public int maxXor(int[] arr){
        int n = arr.length;
        TrieNode root = new TrieNode();
        TrieNode tmp=root;
        int ans=0;
        for(int bit=31;bit>=0;bit--){
            int b = (arr[0]&(1<<bit))>0?1:0;
            if(!tmp.childs.containsKey(b)){
                tmp.childs.put(b, new TrieNode());
            }
            tmp = tmp.childs.get(b);
        }
        tmp.isEnd = true;
        tmp.num = arr[0];

        for(int i=1;i<n;i++){
            tmp = root;

            for(int bit=31;bit>=0;bit--){
                int b = (arr[i]&(1<<bit))>0?1:0;

                if(b==0){
                    if(tmp.childs.containsKey(1)){
                        tmp=tmp.childs.get(1);
                    }else tmp = tmp.childs.get(0);
                }
                if(b==1){
                    if(tmp.childs.containsKey(0)){
                        tmp=tmp.childs.get(0);
                    }else tmp = tmp.childs.get(1);
                }
            }
            // System.err.println("maximum for a[i]  = "+tmp.num);
            ans = Math.max(ans, arr[i]^tmp.num);

            tmp = root;
            for(int bit=31;bit>=0;bit--){
                int b = (arr[i]&(1<<bit))>0?1:0;

                if(!tmp.childs.containsKey(b)){
                    tmp.childs.put(b, new TrieNode());
                }
                tmp = tmp.childs.get(b);
            }
            tmp.isEnd = true;
            tmp.num = arr[i];
        }

        return ans;
    }
}
