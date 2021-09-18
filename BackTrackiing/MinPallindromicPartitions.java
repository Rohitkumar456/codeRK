
/*

This is not optimized (this is using concept of backtracking)

Given a String S, we need to find the minimum number partitions of that string such that each partition
 is a pallindrome 

 For ex:- String S = "aabaad"
 so, min part = 1 as:- aabaa|d
*/

import java.util.*;
public class MinPallindromicPartitions {
    public static void main(String[] args) {
        MinPallindromicPartitions mp = new MinPallindromicPartitions();
        String s = "aabaabaadfg";
        int ans = mp.minPartition(s, 0);
        System.out.println(ans);
    }

    public int minPartition(String s,int start){
        if(start==s.length()) return -1;
        if(start==s.length()-1) return 0;

        String tmp = "";
        int ans = Integer.MAX_VALUE;
        for(int i=start;i<s.length();i++){
            tmp+=s.charAt(i);
            
            if(isPallindrome(tmp)){
                ans = Math.min(ans, minPartition(s, i+1)+1);
            }
        }
        return ans;
    }
 
    public boolean isPallindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }
    
}
