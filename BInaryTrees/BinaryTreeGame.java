
/**
 * 
 * ALi and billu are platying a game on a binary tree A              ==>   1<=|A|<=100000
 * 
 * Ali has a WHITE bucket of paint and illu has a BLACK bucket of paint.
 * 
 * The game is as follows:- 
 * 1) ALi start the game first 
 * 2) Each player chooses a previously unpainted node and piant with his colour.
 * 3) After both of themhave painted all the nodes, Billu will paint all the white nodes adjacent to black ones with his colour, Black
 * 4) If, after the above opeartion, There is any 1 node that is still white, ALi wins otherwise Billu wins 
 * 
 * 
 * Solution approach, since each player will have an alternate turn to paint a node in the tree and also, ALi have the first turn
 * 
 *      If any kindd of binary tree will have a structure like this :-    node
 *                                                                       /    \
 *                                                                    node    node
 * 
 * then ALi will win Always, because Ali has the first turn so he can always paint the root node first, and then any other node
 * so after operation 3 , one white node will always be left and hence makes ali the winner of game.
 * 
 * SO, we just need to find weather this structure exist or not in the binary tree.
 * 
 * 
 */
import java.util.*;

public class BinaryTreeGame {
    public static void main(String[] args) {
        TreeNode root = new LowestCommonAncesstor().buildBinaryTree();
        boolean ans = new BinaryTreeGame().win(root);
        System.out.println(ans);
    }


    public boolean win(TreeNode root){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        TreeNode cur;
        while(q.size()!=0){
            cur = q.poll();
            if(isLeaf(cur.left)&&isLeaf(cur.right)) return true;
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
        return false;
    }
    
    public boolean isLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left==null&&root.right==null) return true;
        return false;
    }
}
