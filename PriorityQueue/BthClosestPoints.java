import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

    Here, the distance between two points on a plane is the Euclidean distance.

    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

    NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 * 
 * 
 * 
 */


public class BthClosestPoints {

    private class point{
        int x;
        int y;
        double distance;

        point(int i, int j){
            this.x = i;
            this.y = j;
            this.distance = Math.sqrt(i*i + j*j);
        }

    }

    public static void main(String[] args) {

        BthClosestPoints bcp = new BthClosestPoints();
        int[][] points = {{1,3},{-2,2}};
        int b = 1;
        int[][] ans = bcp.BclosestPoints(points, b);
        for(int[]x:ans){
            System.out.println(x[0]+" "+x[1]);
        }
        
    }


    public int[][] BclosestPoints(int[][] points, int b){
        int[][] closestPoints = new int[b][2];

        PriorityQueue<point>minHeap = new PriorityQueue<>(new Comparator<point>(){
            public int compare(point a, point b){
                if(a.distance>b.distance) return 1;
                else if(a.distance<b.distance) return -1;
                else return 0;
            }
        });

        for(int i=0;i<points.length;i++){
            minHeap.offer(new point(points[i][0], points[i][1]));
        }

        for(int i=0;i<b;i++){
            point p = minHeap.poll();
            closestPoints[i][0] = p.x;
            closestPoints[i][1] = p.y;
        }
        return closestPoints;
    }
}
