import java.util.*;

/**
 * Given string A denoting an infix expression. Convert the infix expression into postfix expression.

    String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.

    Find and return the postfix expression of A.
 */

public class PostfixExpression {
    public static void main(String[] args) {
        PostfixExpression pe = new PostfixExpression();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = pe.convert(exp);
        
    }

    public String convert(String s){
        StringBuilder postExp = new StringBuilder("");

        Stack<Character>st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a'&&ch<='z'){
                postExp.append(ch);
            }else if(ch==')'){
                char x = st.pop();
                while(x!='('){
                    postExp.append(x);
                    x = st.pop();
                }
            }else{
                if(st.isEmpty()) st.push(ch);
                else{
                    if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
                        if(st.peek()=='(') st.push(ch);
                        else{
                            while(!st.isEmpty()&&getPrecedence(ch)<=getPrecedence(st.peek())){
                                postExp.append(st.pop());
                            }
                            st.push(ch);
                        }
                        
                    }else st.push(ch);
                }
            }
        }

        while(!st.isEmpty()){
            postExp.append(st.pop());
        }

        System.out.println(postExp.toString());
        return "";

    }

    public int getPrecedence(char ch){
        if(ch=='^') return 5;
        else if(ch=='/'||ch=='*') return 4;
        else if(ch=='+'||ch=='-') return 3;
        else return 1;
    }
}
