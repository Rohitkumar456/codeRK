/*

Given a list fo valid words and also a String, We need to return true if that string can be brokken down into valid words or not

For ex:- validWords: ['i','goes','man','like','an','mango']
         String s = "ilikemangoes"

    this will return true as String can be broken like := "i" + "like" + "man" + "goes"

*/



import java.util.*;

public class CanBrokenIntoValidWords {

    HashSet<String>validWords = new HashSet<>();

    public static void main(String[] args) {
        CanBrokenIntoValidWords cw = new CanBrokenIntoValidWords();
        cw.validSet();

        String s = "ilikemangoes";
        boolean ans = cw.canBeBroken(s,0);
        System.out.println(ans);
    }

    public boolean canBeBroken(String s,int start){
        if(start >=s.length()) return true;

        String tmp = "";
        for(int i=start;i<s.length();i++){
            tmp+=s.charAt(i);
            if(validWords.contains(tmp)){
                if(canBeBroken(s, i+1)) return true;
            }
        }
        return false;
    }

    public void validSet(){
        validWords.add("i");
        validWords.add("goes");
        validWords.add("man");
        validWords.add("mango");
        validWords.add("like");
    }
    
}
