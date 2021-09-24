
/**
 * 
    * We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:

    Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.

    Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. 
    It must count the number of contacts starting with B[i].

    You have been given sequential add and find operations. You need to perform each operation in order.

    And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
 * 
 * 
 * For ex:- Input are:- 
 *          A = [0, 0, 1, 1]
            B = ["hack", "hacker", "hac", "hak"]

        Output should be:- [2, 0]                   -> There are 2 contacts that starts with "hac" and none of the contacts starts
                                                         with "hak" and hence, 0
 */

import java.util.*;

public class ContactFinder {

    private class TrieNode{
        int cnt;
        HashMap<Character,TrieNode>childs;
        boolean isEnd;

        TrieNode(){
            this.cnt = 0;
            this.childs = new HashMap<>();
            this .isEnd = false;
        }
    }

    public static void main(String[] args) {
        ContactFinder cf = new ContactFinder();
        int[]a = {0, 0, 1, 1};
        String[] b = {"hack", "hacker", "hac", "hak"};
        int[] ans = cf.solve(a, b);
        for(int x:ans){
            System.out.println(x);
        }
        
    }

    public int[] solve(int[] op,String[] words){
        TrieNode root = new TrieNode();
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i=0;i<op.length;i++){
            if(op[i]==0){
                insertInTrie(root, words[i]);
            }else{
                answer.add(numberOfWordsWithPrefix(root,words[i]));
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public int numberOfWordsWithPrefix(TrieNode root, String prefix){
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(cur.childs.containsKey(ch)){
                cur = cur.childs.get(ch);
            }else return 0;
        }
        return cur.cnt;
    }

    public void insertInTrie(TrieNode root,String contact){
        TrieNode cur = root;
        for(int i=0;i<contact.length();i++){
            char ch = contact.charAt(i);
            if(!cur.childs.containsKey(ch)){
                cur.childs.put(ch, new TrieNode());
            }
            cur = cur.childs.get(ch);
            cur.cnt++;
        }
        cur.isEnd = true;
    }
}
