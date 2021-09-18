import java.util.ArrayList;
import java.util.Queue;

import javax.management.Query;

/**
 * 
 * Binary tree, zig zag traversal,  
 * 
 *               1
 *           2      3   --- 2
 *         4   5   6  7
 * 
 *   1  32  4567
 * 
 *     1
 *     23
 *     4567
 *      
 */

 /**
  * q2:-  
    
  


  */

 class Treenode{
     int v;
     Treenode left,right;
 }

public class infibeam {
    public static void main(String[] args) {
        
        
        
    }

    public solve(Treenode root){

        Queue<Treenode>lq = new LinkedList<>();

        lq.add(root);
        int level=0;
        while(lq.size()!=0){
            level++;
            int n = lq.size();
            ArrayList<Integer>nodes = new ArrayList<>();
            for(int i=0;i<n;i++){
                Treenode tmp = lq.poll();
                nodes.add(tmp.val);
                if(tmp.left!=null) lq.add(tmp.left);
                if(tmp.right!=null) lq.add(tmp.right);
            }

            if((level&1)==0){
                for(int i=nodes.size()-1;i>=0;i--){
                    System.out.println(nodes.get(i));
                }
            }else{
                for(int i=0;i<nodes.size();i++){
                    System.out.println(nodes.get(i));
                }
            }

        }

        List<Queue>
        PriorityQueue<Queue>pq;

        q1, q2 

        pq.poll();

    }
}


/**
 * SaurabhKumar Agrawal5:54 PM



  3 5 12 16
  4 8 13 
  2 7 15 ...  
  6 9 10 ...

  N ...........



class Stream{
	peek
	poll
}


class Sorter{
	List<Stream> list;
	

	public int getNext(){

		
	}
}
Tech Interview (Scaler) : Rohit : 3+ Years : Software Engineer : Bangalore
 * 
 * 
 * 
 * 
 * q3:- Given a binary 
 * 
 * two mehods, inorder sorted order, bst
 * 
 * 
 * 2nd binary 
 * 
 *     (min, max)
 * 
 *  -inf,+inf
 * 
 * /
 * -in,
 * 
 * 
 * 
 */
