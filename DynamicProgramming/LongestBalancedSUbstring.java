import java.util.Stack;

/**
 * Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string .

    Conditions for a string to be balanced :

    Blank string is balanced ( However blank string will not be provided as a test case ).
    If B is balanced : (B) , [B] and {B} are also balanced.
    If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced.
 * 
 */

public class LongestBalancedSUbstring {
    public static void main(String[] args) {
        LongestBalancedSUbstring lbs = new LongestBalancedSUbstring();
        String s = "[[]]){)}]}][[)[]}[)]}{{[([[]]()(([)]{}]}{{)(]}[][)()(]}[][(({][[][";
        int ans = lbs.balancedSubstring(s);
        System.out.println("ans="+ans);
    }

    public int balancedSubstring(String s){
        int len=0;
        int n = s.length();
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = i-2>=0?dp[i-2]+2:2;
                }else if(dp[i-1]!=0&&(i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1]+2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                }
            }else if(ch=='}'){
                if(s.charAt(i-1)=='{'){
                    dp[i] = i-2>=0?dp[i-2]+2:2;
                }else if(dp[i-1]!=0&&(i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='{'){
                    dp[i] = dp[i-1]+2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                }
            }else if(ch==']'){
                if(s.charAt(i-1)=='['){
                    dp[i] = i-2>=0?dp[i-2]+2:2;
                }else if(dp[i-1]!=0&&(i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='['){
                    dp[i] = dp[i-1]+2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                }
            }
            System.out.print(dp[i]+" ");
            len = Math.max(dp[i],len);
        }

        return len;
    }
}
