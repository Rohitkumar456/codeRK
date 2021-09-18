

/**
 * 
 * Given a BST and the two nodes in the correct BST is swapped with each other.
 * Find the swapped nodes
 * 
 * 
 */


public class FindSwappedNodes {
    TreeNode first=null,last=null,prev=null;
    public static void main(String[] args) {
        FindSwappedNodes fsn = new FindSwappedNodes();
        TreeNode root = fsn.buildBst();
        fsn.getSwappedNodes(root);
        System.out.println(fsn.first.data+" "+fsn.last.data);
    }

    public void getSwappedNodes(TreeNode root){
        if(root == null) return;
        getSwappedNodes(root.left);
        if(prev!=null && root.data < prev.data){
            if(first==null){
                first = prev;
                last = root;
            }else{
                last = root;
            }
            
        }
        prev=root;
        getSwappedNodes(root.right);
    }


    public TreeNode buildBst(){
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(9);
        root.right = new TreeNode(10);                  //swapped node
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(20);            //swapped node
        root.right.left = new TreeNode(15);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(6);
        return root;
    }
}
