import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer A, you have to find the Ath Perfect Number.

    A Perfect Number has the following properties:

    It comprises only 1 and 2.

    The number of digits in a Perfect number is even.

    It is a palindrome number.

    For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 */

public class PerfectNumber {
    public static void main(String[] args) {
        PerfectNumber pn = new PerfectNumber();
        int[] digits = {1,2};
        String num = pn.generate(digits, 2);
        System.out.println(num);
        for(int i=num.length()-1;i>=0;i--){
            num+=num.charAt(i);
        }
        System.out.println(num);

    }

    public String generate(int[] digits,int k){
        Queue<String>num = new LinkedList<>();
        int j=0;

        for(int i=0;i<digits.length;i++){
            num.add(""+digits[i]);
            j++;
            if(j==k) return ""+digits[i];
        }
        while(j<k){
            String n = num.poll();
            for(int i=0;i<digits.length;i++){
                String x = n+digits[i];
                num.add(x);
                j++;
                if(j==k) return x;
            }
        }
        return "";
    }
}
