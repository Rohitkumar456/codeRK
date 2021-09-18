
/**
 * Given a binary search tree, find the kth smallest element of the bst.
 * 
 * 
 */



import java.util.*;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        this.data = d;
        this.left = null;
        this .right = null;
    }
}
public class FindKthSmallestElement {
    int ans = -1;
    int k=0;
    public static void main(String[] args) {
        FindKthSmallestElement fks = new FindKthSmallestElement();
        TreeNode root = fks.buildBst();
        int ele = fks.kthSmallest(root,5);
        fks.k = 5;
        System.out.println(ele);
        fks.kthInorder(root);
        System.out.println(fks.ans);
    }

    /**
     * Approach 2:- 
     * while doing the in-orde traversal  of the BST we will keep a counter and increment while processing
     * the node.
     * whenever the cnt==k, we found the kth smallest element and we can just store that node;
     * 
     */
    public void kthInorder(TreeNode root){
        if(root == null) return;
        kthInorder(root.left);
        k--;
        if(k==0){
            ans=root.data;
            return;
        }
        kthInorder(root.right);
    }




    /**
     * Approach 1:- here, we will do in in-order traversal of the BSt and we will store that in an array
     *              in-order of BST will be in sorted order itself,
     *                 then, we will just find out the kth element in the array
     * 
     * TC:- o(n);
     * SC:- O(n)
     */

    public int kthSmallest(TreeNode root,int k){
        ArrayList<Integer>list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root,ArrayList<Integer>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right, list);
    }



    public TreeNode buildBst(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(6);
        return root;
    }
}
