/**
 * Given two arrays of strings A of size N and B of size M.

    Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

    NOTE: modification is defined as converting a character into another character.
 * 
 * 
 */


import java.util.*;

public class ModifiedSerach {
    private class TrieNode{
        HashMap<Character,TrieNode>childs;
        boolean isEnd;


        TrieNode(){
            this.childs = new HashMap<>();
            this.isEnd = false;
        }
    }
    public static void main(String[] args) {
        ModifiedSerach ms= new ModifiedSerach();
        String[] dictionary = {"data", "circle", "cricket"};
        String[] words = {"date", "circel", "crikket", "data", "circl"};

        String ans = ms.search(dictionary, words);
        System.out.println(ans);
    }

    public String search(String[] dictionary,String[] words){
        int n = words.length;
        String ans = "";

        TrieNode root = new TrieNode();
        root = buildDictionary(dictionary, root);
        TrieNode cur = root;
        int j=0;
        for(String word:words){
            
            boolean flag = false;
            
            StringBuilder sb = new StringBuilder();
            for(int p=0;p<word.length();p++){
                sb.setLength(0);
                sb.append(word);
                for(char ch ='a';ch<='z';ch++){
                    if(ch!=word.charAt(p)){
                        sb.setCharAt(p, ch);
                        flag = flag|isPresent(root, sb.toString());
                    }
                }
            }
            if(flag){
                ans+='1';
            }else ans+='0';         
        }
        return ans;
    }

    public boolean isPresent(TrieNode root,String s){
        // System.out.println(s);
        TrieNode cur = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!cur.childs.containsKey(ch)){
                return false;
            }else cur = cur.childs.get(ch);
        }

        return cur.isEnd;

    }

    public TrieNode buildDictionary(String[] dictionary,TrieNode root){
        for(String w:dictionary){
            TrieNode cur = root;
            for(int i=0;i<w.length();i++){
                char ch = w.charAt(i);

                if(!cur.childs.containsKey(ch)){
                    cur.childs.put(ch, new TrieNode());
                }
                cur = cur.childs.get(ch);
            }
            cur.isEnd = true;
        }
        return root;
    }
}
