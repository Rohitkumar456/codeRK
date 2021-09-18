
/*
Given a String S, print all possible ways of partitions of string which are palindrome.

for example :- s = "aaba"
        1) a,a,b
        2) aa,b
        3)a,aba
*/
import java.util.*;
public class PalindromicPartitions {
    ArrayList<ArrayList<String>>totalPartitions = new ArrayList<>();
    public static void main(String[] args) {
        
        PalindromicPartitions pp = new PalindromicPartitions();

        String s = "a";
        pp.getPartitions(s, 0, new ArrayList<>());
        pp.show();

    }

    public void getPartitions(String s, int st, ArrayList<String>set){
        if(st==s.length()){
                totalPartitions.add(set);
                return;
        }

        if(st==s.length()-1){
            set.add(""+s.charAt(st));
            totalPartitions.add(set);
            return;
        }

        String tmp = "";
        for(int i=st;i<s.length();i++){
            tmp+=s.charAt(i);
            if(isPalindrome(tmp)){
                ArrayList<String>t = new ArrayList<>(set);
                t.add(tmp);
                getPartitions(s, i+1, t);
            }
        }
    }

    public boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }

    public void show(){
        for(ArrayList<String>tmp:totalPartitions){
            System.out.print("[ ");
            for(String s:tmp){
                System.out.print(s+",");
            }
            System.out.println(" ]");
        }
    }
}
