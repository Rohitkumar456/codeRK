/**
 * 
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

    You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

    While moving from building i to building i+1 (0-indexed),

    If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
    If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
    Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * 
 */


import java.util.*;
public class FurthestBuildingWeCanReach {
    public static void main(String[] args) {
        FurthestBuildingWeCanReach fbwc = new FurthestBuildingWeCanReach();
        int[] buildings = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        int ans = fbwc.solve(buildings,bricks,ladders);
        System.out.println(ans);
    }

    public int solve(int[] buildings,int bricks, int ladders){
        Queue<Integer>heap = new PriorityQueue<>();
        int i;
        for(i=0;i<buildings.length-1;i++){
            int diff = buildings[i+1]-buildings[i];
            if(diff>0){
                heap.add(diff);
                if(ladders>0){
                    ladders--;
                }else{
                    if(bricks<heap.peek()) return i;
                    else{
                        bricks-=heap.peek();
                        heap.poll();
                    }
                }
            }
        }
        return i;
    }
}
