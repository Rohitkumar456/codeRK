

import java.util.*;
public class ParsingBoolenExp {
    Stack<Character>expStack = new Stack<>();
    public static void main(String[] args) {

        ParsingBoolenExp pb = new ParsingBoolenExp();
        pb.solve("|(f,t)");
    }

    public void solve(String s){
        int i=s.length()-1;
        while(i>0){
            while(i>=0&&s.charAt(i)!='('){
                if(s.charAt(i)!=','){
                    expStack.push(s.charAt(i));
                }
                i--;
            }
            i--;
            char op = s.charAt(i);
            if(expResult(op)){
                expStack.push('t');
            }else{
                expStack.push('f');
            }
        }
        if(!expStack.isEmpty()&&expStack.pop()=='t'){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    public boolean expResult(char operartor){
        boolean ans = true;

        switch (operartor) {
            case '&': {
                ans=true;
                while(!expStack.isEmpty()){
                    char x = expStack.pop();
                    if(x=='f') {ans = false;}
                    if(x==')') return ans;
                }
                return true;
            }
            case '|': {
                ans=false;
                while(!expStack.isEmpty()){
                    char x = expStack.pop();
                    if(x=='t') {ans = true;}
                    if(x==')') return ans;
                }
                return true;
            }
            case '!': {
                ans=true;
                while(!expStack.isEmpty()){
                    char x = expStack.pop();
                    if(x=='t') {ans = false;}
                    if(x==')') return ans;
                }
                return true;
            }
            default:
                break;
        }

        return ans;


    }
}
