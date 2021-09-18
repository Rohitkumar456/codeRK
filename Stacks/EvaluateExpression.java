/**
 * An arithmetic expression is given by a charater array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each character may be an integer or an operator.
 */

import java.util.*;
public class EvaluateExpression {
    public static void main(String[] args) {
        
        EvaluateExpression ex = new EvaluateExpression();

        String[] a = {"2", "1", "+", "3", "*"};
        int ans = ex.evaluate(a);
        System.out.println(ans);
    }

    public int evaluate(String[] a){
        int ans = 0;
        Stack<Integer>exp = new Stack<>();
        String s;
        for(int i=0;i<a.length;i++){
            s = a[i];
            if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/")){
                exp.push(Integer.parseInt(s));
            }else{
                int x = exp.pop();
                int y = exp.pop();
                exp.push(reslut(s, y, x));
            }
        }

        return exp.peek();
    }

    public int reslut(String op, int a, int b){
        int ans=0;
        switch(op){
            case "+":{
                ans = a+b;
                break;
            }
            case "-":{
                ans = a-b;
                break;

            }
            case "*":{
                ans = a*b;
                break;
                
            }
            case "/":{
                ans = a/b;
                break;
                
            }
        }

        return ans;
    }
}
