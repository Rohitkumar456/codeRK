import java.util.Arrays;
import java.util.List;

/**
 * 
 * waf, given a list return the first repeated elemnt in list
 * 
 * ex:- 1 2 1 2
 * fr = 1
 * 
 * ex: abba
 * fr = b
 * 
 * 
 * 
 */

import java.util.*;




public class spotdrft2 {
    public static void main(String[] args) {
        spotdrft2 sd = new spotdrft2();
        List<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        
        Integer ans = sd.firstRepeatedElement(list);
        System.out.println(ans);

    }
    
    public <T> T firstRepeatedElement(List<T>list){
        HashMap<T,Integer>map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))) return list.get(i);
            map.put(list.get(i),i);
        }
        return null;
    }

}
