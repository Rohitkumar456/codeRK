
import java.util.*;
public class GenerateNumberWithDigits {
    public static void main(String[] args) {
        GenerateNumberWithDigits gnwd = new GenerateNumberWithDigits();

        int[] digits = {1,2,3};
        int ans = gnwd.getNum(digits, 15);
        System.out.println(ans);
    }

    public int getNum(int[] digits,int k){
        Queue<Integer>numbers = new LinkedList<>();
        int j=0;
        int num=0;
        for(int i=0;i<digits.length;i++){
            int x = num*10+digits[i];
            numbers.add(x);
            j++;
            if(j==k) return x;
        }
        while(j<=k){
            num = numbers.poll();
            for(int i=0;i<digits.length;i++){
                int x = num*10+digits[i];
                numbers.add(x);
                j++;
                if(j==k) return x;
            }
        }
        return -1;
    }

}
