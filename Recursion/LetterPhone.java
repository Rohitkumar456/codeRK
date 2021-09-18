/*

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
    1 -> 1
    2 -> a,b,c
    3 -> d,e,f
    4 -> g,h,i
    5 -> j,k,l
    6 -> m,n,o
    7 -> p,q,r,s
    8 -> t,u,v
    9 -> w,x,y,z;
*/

import java.util.*;
public class LetterPhone {

    HashMap<Integer,ArrayList<String>>hm = new HashMap<>();
    ArrayList<String>ans = new ArrayList<>();

    public static void main(String[] args) {
        
        String phone = "23";
        LetterPhone lp = new LetterPhone();
        lp.buildMap();
        // lp.generate(phone,phone.length()-1);
        lp.gerateIteratively(phone);
        lp.printStrings();
    }

    public void buildMap(){
        hm.put(0, new ArrayList<>(Arrays.asList("0")));
        hm.put(1, new ArrayList<>(Arrays.asList("1")));
        hm.put(2, new ArrayList<>(Arrays.asList("a","b","c")));
        hm.put(3, new ArrayList<>(Arrays.asList("d","e","f")));
        hm.put(4, new ArrayList<>(Arrays.asList("g","h","i")));
        hm.put(5, new ArrayList<>(Arrays.asList("j","k","l")));
        hm.put(6, new ArrayList<>(Arrays.asList("m","n","o")));
        hm.put(7, new ArrayList<>(Arrays.asList("p","q","r","s")));
        hm.put(8, new ArrayList<>(Arrays.asList("t","u","v")));
        hm.put(9, new ArrayList<>(Arrays.asList("w","x","y","z")));
    }

    public void generate(String phone,int i){
        if(i<0) return;
        if(i==0){
            for(String c:hm.get(phone.charAt(i)-'0')){
                ans.add(c);
            }
            return;
        }
        generate(phone, i-1);
        ArrayList<String>tmp = new ArrayList<>();
        for(int j=0;j<ans.size();j++){
            for(String s:hm.get(phone.charAt(i)-'0')){
                tmp.add(ans.get(j)+s);
            }
        }
        ans=tmp;
    }

    public void printStrings(){
        for(String s:ans){
            System.out.println(s);
        }
    }

    //Iterative way
    public void gerateIteratively(String phone){
        ans.add("");
        for(int i=0;i<phone.length();i++){
            char ch = phone.charAt(i);
            ArrayList<String>list = hm.get(ch-'0');
            ArrayList<String>tmp = new ArrayList<>();
            for(String s:ans){
                for(String t:list){
                    tmp.add(s+t);
                }
            }
            ans = tmp;
        }
    }
    
}
