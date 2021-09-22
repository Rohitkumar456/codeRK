import java.util.ArrayList;

/**
 * Given a binary , we need to find the lowest common ancesstor for the two provided nodes.
 * All the elemnts in the binary tree will be unique.
 * 
 *   The tree in consideration is:- 
 *                                    
 *                              10
 *                           /      \
 *                         9          20
 *                      /    \      /    \
 *                    4       8    15      16
 *                  /  \
 *                 1    6
 */
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }

}
public class LowestCommonAncesstor {
    ArrayList<Integer>listA = new ArrayList<>();
    ArrayList<Integer>listB = new ArrayList<>();
    int a=1,b=1;
    public static void main(String[] args) {
        LowestCommonAncesstor lca = new LowestCommonAncesstor();
        ArrayList<Integer>alist = new ArrayList<>();
        TreeNode root = lca.buildBinaryTree();
        lca.buildAncesstorList(root, 6,9, alist);
        lca.getLcaBits(root, 6, 9, 0, 1);
        System.out.println(lca.a+" "+lca.b);
        int val = lca.getLCA();
        System.out.println(val);
    }

    /**
     * Approach 2:- we will use the idea of representing a path of any node from root node as a
     * combination of 0,s and 1's, i.e 0 if we are moving to left and 1 if we are moving to right.
     * that way we can get the path and then we can store the path in a single integer number instaed 
     *  of maintaing a separate list. This way we will reduce the space complexity to o(1);
     * 
     * 
     */

     public void getLcaBits(TreeNode root,int n1,int n2,int bits,int bit){
         if(root==null) return;
         bits = (bits<<1)|bit;
         if(root.data == n1){
            a=bits;
         }else if(root.data == n2){
             b=bits;
         }
         getLcaBits(root.left, n1,n2, bits, 0);
         getLcaBits(root.right, n1,n2, bits, 1);
         bits=bits>>1;
     }



    /**
     * Approach 1:- We will find the path of the two nodes starting from root using pre-order traversal
     *  and maintain them in lists, 
     * then we just need to check the last common element in the list that will be the lowest
     * common ancesstor for the nodes.
     * 
     * 
     */
    public int getLCA(){
        int i;
        for(i=0;i<listA.size()&&i<listB.size();i++){
            if(listA.get(i)!=listB.get(i)) break;
        }
        if(i==0) return -1;
        return listA.get(i-1);
    }

    public void buildAncesstorList(TreeNode root,int a,int b,ArrayList<Integer>alist){
        if(root == null) return;
        alist.add(root.data);
        if(root.data == a){
            for(int x:alist){
                listA.add(x);
            }
        }else if(root.data == b){
            for(int x:alist){
                listB.add(x);
            }
        }
        buildAncesstorList(root.left, a,b, alist);
        buildAncesstorList(root.right, a,b, alist);
        alist.remove(alist.size()-1);
    }


    public TreeNode buildBinaryTree(){               //                           10
                                                    //                          /     \    
        TreeNode root = new TreeNode(10);           //                        9         20
        root.left = new TreeNode(9);                //             4          8            15        16
        root.right = new TreeNode(20);              //          1     6
        root.left.left = new TreeNode(4);           //
        root.left.right = new TreeNode(8);          //
        root.right.left = new TreeNode(15);         //
        root.right.right = new TreeNode(16);        //    
        root.left.left.left = new TreeNode(1);      //
        root.left.left.right = new TreeNode(6);     //
        return root;
    }
}
