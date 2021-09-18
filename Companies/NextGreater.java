/**
 * 4) Find the next greater number with the same set of digits.
    N = 218765
    Output : 251678


    n = 218756
    218765

    n = 587654321          
    612345578

    n = 958753                  357859
    978553
    n = 65432

 */


import java.util.*;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
public class NextGreater {
    public static void main(String[] args) {
        
        NextGreater ng = new NextGreater();
        int n = 587654321;
        int ans = ng.nextGreater(n);
        System.out.println(ans);

    }

    public int nextGreater(int num){
        int tmpNum = num;
        int nxtNum=0;
        ArrayList<Integer>digits = new ArrayList<>();
        while(tmpNum>1){
            int d = tmpNum%10;
            digits.add(d);
            tmpNum/=10;
        }
        int i=1;
        while(i<digits.size()){
            if(digits.get(i)<digits.get(i-1)) break;
            i++;
        }
        if(i==digits.size()) return -1;
        int p=0;
        for(int j=0;j<i;j++){
            if(digits.get(j)>digits.get(i)){
                int t = digits.get(i);
                digits.set(i, digits.get(j));
                digits.set(j, t);
                break;
            }
        }

        for(int j=digits.size()-1;j>=i;j--){
            nxtNum = nxtNum*10+digits.get(j);
        }
        for(int j=0;j<i;j++){
            nxtNum = nxtNum*10+digits.get(j);
        }
        return nxtNum;
    }
}
