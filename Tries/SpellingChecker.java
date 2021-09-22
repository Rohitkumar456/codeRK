
/**
 * Given an array of words A (dictionary) and another array B (which contain some words).

    You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

    Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

    Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

    NOTE: Try to do this in O(n) time complexity.


 */

import java.util.*;



public class SpellingChecker {
    private class TrieNode {
        HashMap<Character, TrieNode> childs;
        boolean isEnd;
    
        TrieNode() {
            this.childs = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        SpellingChecker sc = new SpellingChecker();
        String[] dictionary = {"tape", "bcci"};
        String[] words = {"table", "cci"};
        int[] ans = sc.check(dictionary, words);

        for(int x:ans){
            System.out.print(x+" ");
        }

    }

    public int[] check(String[] dictionary, String[] words) {
        TrieNode root = new TrieNode();
        TrieNode tmp = root;

        int[] ans = new int[words.length];
        Arrays.fill(ans, -1);

        for (String s : dictionary) {
            tmp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (!tmp.childs.containsKey(ch)) {
                    tmp.childs.put(ch, new TrieNode());
                }
                tmp = tmp.childs.get(ch);
            }
            tmp.isEnd = true;
        }
        int j=0;
        for (String s : words) {
            tmp = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(!tmp.childs.containsKey(ch)){
                    ans[j] = 0;
                    break;
                }
                tmp=tmp.childs.get(ch);
            }
            if(tmp.isEnd&&ans[j]==-1){
                ans[j] = 1;
            }else{
                ans[j] = 0;
            }
            j++;
        }

        return ans;
    }
}
