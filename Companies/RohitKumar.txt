
/**Three Number Sum

Write a function that takes in a non-empty array of distinct integers and 
an integer representing a target sum. The function should find all triplets in
 the array that sum up to the target sum and return a two-dimensional array of 
 all these triplets. The numbers in each triplet should be ordered in ascending 
 order, and the triplets themselves should be ordered in ascending order with respect 
 to the numbers they hold.

If no three numbers sum up to the target sum, the function s empty array
 * 
 * Sample Input:
    Array = [12, 3, 1, 2, -6, 5, -8, 6]   [-8,-6,1,2,3,5,6,12]
    targetSum = 0

    Sample Output: 
    [ [-8, 2, 6], [-8, 3, 5], [-6, 1, 5] ]
 * 
 * 
 * 
 * Q2:- 
 * 
 * 
 *  [pool of videos at aws]
 *  
 *  
 * 
 *  like, comment, 
 *  no of view count, creator
 * 
 *  like,
 * 
 *  hashMap<videoId,noOfLikes>
 *  
 *  hasMap<userId,videoId>
 *  
 *  intersets, 
 *  push notifation
 *  
 *  PK
 *  BinaryOperation
 * 
 *  poh file
 *  
 * 
 * 
 *  get,post{data},put{data},patch{},delete
 * 
 * kubectl
 * 
 * Ludo
 * 
 * User
 *  -userId
 *  -userName
 *  - phoneNumber
 *  - email
 *  - difficulty
 *  - rewards+()
 * 
 * bluethooth
 *  
 *  - online play  - online mathching plyer
 *   match with nearAround
 * 
 * actual Game
 *  - 4 quadrants
 *  - random assign to each player
 * 
 * 
 * GameId
 *  - fk userId
 *  - winner
 *  - 2nd
 * Winner
 *  - 
 * 
 * 
 * 
 */
import java.util.*;
public class GamesKraft {

    public static void main(String[] args) {
        
    }

    public List<List<Integer>> getTriplets(int[] arr, int target){

        List<List<Integer>>triplets = new ArrayList<>();
        Arrays.sort(a);
        int size = a.length;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                for(int k=j+1;k<size;k++){
                    if(a[i]+a[j]+a[k]==target){
                        List<Integer>triplet = new ArrayList<>();
                        triplet.add(a[i]);
                        triplet.add(a[j]);
                        triplet.add(a[k]);
                        triplets.add(triplet);
                    }
                }
            }
        }

        return triplets;
    } 

    public List<List<Integer>> gettriplets2(int[]arr, itn target){
        int size = arr.length;
        Arrays.sort(arr);

        for(int i=0;i<size;i++){
            int j=i+1;
            int k = size-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==target){
                    List<Integer>triplet = new ArrayList<>();
                    triplet.add(a[i]);
                    triplet.add(a[j]);
                    triplet.add(a[k]);
                    triplets.add(triplet);
                }else if(sum>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
    }
    
}
