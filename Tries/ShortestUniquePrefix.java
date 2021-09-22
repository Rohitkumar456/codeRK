/**
 * 
 * Given a list of N words. Find shortest unique prefix to represent each word in the list.

    NOTE: Assume that no word is prefix of another. In other words, the representation is always possible
 * 
 * 
 */

import java.util.*;
public class ShortestUniquePrefix {

    private class TrieNode{
        HashMap<Character,TrieNode>childs;
        int count;

        TrieNode(){
            this.childs = new HashMap<>();
            this.count = 0;
        }
    }


    public static void main(String[] args) {

        ShortestUniquePrefix sup = new ShortestUniquePrefix();
        String[] words = {"zebra", "dog", "duck", "dove"};

        String[] ans = sup.shortestPrefix(words);
        System.out.println(ans[3]);
        
    }

    public String[] shortestPrefix(String[] words){

        TrieNode root = new TrieNode();
        TrieNode cur;
        String[] prefixes = new String[words.length];
        //inserting words into the trie character by character
        for(String s:words){
            cur = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);

                if(!cur.childs.containsKey(ch)){
                    cur.childs.put(ch, new TrieNode());
                }
                cur.count++;
                cur = cur.childs.get(ch);
            }
        }

        //find the shortestunique prefix for each words by traversing the  trie tree
        int j=0;
        for(String s:words){
            cur = root;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                sb.append(ch);
                cur = cur.childs.get(ch);
                if(cur.count==1) break;
            }
            prefixes[j++] = sb.toString();
        }
        return prefixes;
    }
}
