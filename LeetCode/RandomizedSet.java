/*
 * Implement the RandomizedSet class:

    - RandomizedSet() Initializes the RandomizedSet object.
    - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    - bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). 
    Each element must have the same probability of being returned.
    - You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    public static void main(String[] args) {
        
    }
}

class RandomSet {
    Random random;
    List<Integer>list;
    HashMap<Integer,Integer>map;

    public RandomSet(){
        this.random = new Random();
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }


    public boolean insert(int val){
        if(map.containsKey(val)) return false;
        int size = list.size();
        map.put(val, size);
        list.add(val);
        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey(val)) return false;
        int pos = map.get(val);
        int lPos = list.size()-1;
        if(pos!=lPos){
            list.set(pos, list.get(lPos));
            map.put(list.get(lPos), pos);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom(){
        int num = this.random.nextInt(this.list.size());
        return this.list.get(num);
    }

}
