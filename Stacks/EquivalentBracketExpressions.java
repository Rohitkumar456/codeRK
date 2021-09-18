/**
 * Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.
 */
import java.util.*;

public class EquivalentBracketExpressions {
    public static void main(String[] args) {
        EquivalentBracketExpressions ebe = new EquivalentBracketExpressions();

        String a = "-(a-(-z-(b-(c+t)-x)+l)-q)";
        String b = "a-(-b-c)";
        String s1 = ebe.process(a);
        String s2 = ebe.process(b);
        // System.out.println(s1.equals(s2));
    }


    public String process(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character>exp = new Stack<>();
        Stack<Character>tmp = new Stack<>();


        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='('){
                char x = exp.pop();
                while(x!=')'){
                    tmp.push(x);
                    x = exp.pop();
                }
                int p = i-1;
                if(p>=0&&s.charAt(p)=='-'){
                    while(!tmp.isEmpty()){
                        x = tmp.pop();
                        if(x=='-') exp.push('+');
                        else if(x=='+') exp.push('-');
                        else exp.push(x);
                    }
                }else{
                    while(!tmp.isEmpty()){
                        x = tmp.pop();
                        exp.push(x);
                    }
                }
            }else{
                
                if(ch=='-'||ch=='+'){
                    if(exp.peek()=='+'||exp.peek()=='-') continue;
                }
                exp.push(ch);
            }

        }
        // while(exp.peek()=='+'||exp.peek()=='-'){
        //     exp.pop();
        // }
        while(!exp.isEmpty()){
            char x = exp.pop();
            sb.append(x);
        }
        System.out.println(sb.toString());
       return sb.toString();
    }


}
