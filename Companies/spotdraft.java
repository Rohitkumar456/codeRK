
/**
 * LRU cache
 * 
 * 
 * q2:- databse schema for blog
 * 
 * blog
 *  -id long
 *  -author FK(authorId)
 *  - content String
 *  - createdDate Date
 *  - modifiedDate date
 *  - catergory
 *  - List<>Tags
 * 
 * 
 * author
 *  -authorId
 *  -authorName
 * 
 * LikeTable
 *  -fk blogId
 *  - No of likes - long
 *  
 * LikedUsers
 *  - bloId - userId
 * 
 * Comments
 *  -comentId PK
 *  -fk BlogId
 *  - commentContetnt
 *  - userID
 * 
 * Replies
 *  - comenId FK
 *  - ReplyContent
 *  - UserId
 * 
 * Tags
 *  - taGid
 *  - tag
 * 
 * 
 */
import java.util.*;

class LRU{

    int capacity;
    HahMap<Integer,Integer>cache;
    Queue<Integer>priority;

    public LRU(int n){
        this.capacity = n;
        this.cache = new HashMap<>();
        this.priority = new LinkedList<>();
    }
    public int get(int key){
        if(cache.containsKey(key)){
            priority.remove(key);
            priority.add(key);
            return cache.get(key);
        }else return -1;
    }

    public void set(int key, int value){
        if(cache.containsKey(key)){
            priority.remove(key);
            priority.add(key);
            hm.put(key,value);
        }else{
            if(priority.size()==this.capacity){
                priority.poll();
                priority.add(key);
            }else{
                cache.put(key,value);
                priority.add(key);
            }
            hm.put(key,value);
        }
    }

}




public class spotdraft {
    public static void main(String[] args) {
        
    }


}


