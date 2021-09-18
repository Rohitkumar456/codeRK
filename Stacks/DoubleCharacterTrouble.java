/**
 * You are given a string A.

    An operation on the string is defined as follows:

    Remove the first occurrence of same consecutive characters. 
    eg :-  for a string "abbcd", the first occurrence of same consecutive characters is "bb".

    Therefore the string after this operation will be "acd".

    Keep performing this operation on the string until there are no more occurrences of same consecutive characters and return the final string.
 
*/

import java.util.*;
public class DoubleCharacterTrouble {
    public static void main(String[] args) {

        DoubleCharacterTrouble dct = new DoubleCharacterTrouble();

        String s = "abccbc";
        String ans = dct.performOp(s);
        System.out.println(ans);
    }

    public String performOp(String s){
        
        Stack<Character>st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(!st.isEmpty()&&st.peek()==x){
                st.pop();
            }else{
                st.push(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char x:st){
            sb.append(x);
        }
        return sb.toString();
    }
}
