// Given a number n, generate all the graycode ranging from 0 to 2^n -1 i.e all numbers having n bits.
//  GrayCode :- Representation of any number into binay forma where the hamming distance(no. of diff bits)
//  between any two consecutive number is always 1.

// For ex:-  For n=3,   0 = 000,
/*                      1 = 001,
                        2 = 011, 
                        3 = 010, 
                        4 = 110, 
                        5 = 111, 
                        6 = 101, 
                        7 = 100
*/

import java.util.*;
public class GreyCodeGenerator {
    ArrayList<Integer>ans = new ArrayList<>();
    ArrayList<String>greyCode = new ArrayList<>();
    public static void main(String[] args) {
        GreyCodeGenerator gcg = new GreyCodeGenerator();
        int n = 3;
        gcg.generate(n);
        gcg.greycode(n);
    }

    public void generate(int n){
        if(n==1){
            ans.add(0);
            ans.add(1);
            return;
        }
        generate(n-1);
        for(int i=ans.size()-1;i>=0;i--){
            ans.add(ans.get(i)|(1<<(n-1)));
        }
    }

    public void greycode(int n){
        for(int x:ans){
            StringBuilder sb = new StringBuilder();
            for(int i=n-1;i>=0;i--){
                if((x&(1<<i))!=0) sb.append(1);
                else sb.append(0);
            }
            System.out.println(sb.toString());
        }
    }
}
