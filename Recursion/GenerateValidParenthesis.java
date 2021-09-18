
/*

Given a number 'n', generate all possible valid parenthesis sequences of length '2n'.
For ex:- for n=1 :->    ()
         for n=2    :=>     ()(), (())
         for n=3    :=>     ()()(), (())(), ()(()), (()()), ((()))

*/

import java.util.*;

public class GenerateValidParenthesis {

    ArrayList<String>validParenthesis = new ArrayList<>();
    public static void main(String[] args) {
        GenerateValidParenthesis gp = new GenerateValidParenthesis();
        
        String s = "";
        int n = 3;
        gp.generate(s, n, n, n);
        gp.show();
    }

    public void generate(String s, int n, int open, int close){
        
        if(open==0&&close==0){
            validParenthesis.add(s);
            return;
        }

        if(open>0){
            generate(s+"(", n, open-1, close);
        }
        if(close>open){
            generate(s+")", n, open, close-1);
        }
    }

    public void show(){
        for(String s:validParenthesis){
            System.out.println(s);
        }
    }
    
}
