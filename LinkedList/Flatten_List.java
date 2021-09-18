import java.util.*;
class node{
    int val;
    node down;
    node right;
    
    public node(int x){
        this.val = x;
        this.down = null;
        this.right = null;
    }
}

class lnode{
    int val;
    lnode next;
    
    public lnode(int x){
        this.val = x;
        this.next = null;
    }
}

//used in method flatten
class list{
    node head;
    node tail;
    
    public list(node h,node t){
        this.head = h;
        this.tail = t;
    }
}

public class Flatten_List {
    static lnode lhead,tmp;    // used in method convert2
    public static void main(String[] args) {
        node head = new node(1);
        head.down = new node(3);
        // head.down.down = new node(4);
        head.right = new node(2);
        // head.down.right = new node(5);
        // head.down.right.down = new  node(6);
        // head.down.right.right = new node(7);
        // head.down.right.right.right = new node(8);
        convert(head);
        node tmp = head;
        while(tmp!=null){
            System.out.print(tmp.val+"->");
            tmp = tmp.down;
        }
    }

    public static void convert(node root){
        if(root==null) return;
        
        Stack<node>st = new Stack<>();
        st.push(root);
        node tail=root;
        while(!st.empty()){
            System.out.println("size of stack="+st.size());
            node tmp = st.pop();
            if(tail!=tmp) tail.down = tmp;
            while(tmp.down!=null){
                if(tmp.right!=null) st.push(tmp.right);
                tmp = tmp.down;
            }
            tail = tmp;
            if(tmp.right!=null){
                st.push(tmp.right);
                tmp.right=null;
            }
        }
    }


    /*
    another method to flattening the list recursively , here, the appraoch is to maintain the head and tail pointer
    of each list and then combine the lists using the original links i.e we are modifying the original links here
    and returning the head of the final list
    
    after that the originbal list is flatten in-place
    */
    public static list flatten(node root){
        if(root==null) return null;
        if(root.down==null && root.right==null){
            return new list(root,root);
        }
        
        list rlist = flatten(root.right);
        list dlist = flatten(root.down);
        
        list nroot = new list(null,null);
        nroot.head = root;
        
        if(rlist==null && dlist!=null){
            
            root.right = null;
            nroot.tail = dlist.tail;
            nroot.head = root;
        }else if(rlist!=null && dlist==null){
            
            nroot.tail = rlist.tail;
            root.down = rlist.head;
            root.right=null;
            nroot.head = root;
        }else{
            dlist.tail.down = rlist.head;
            root.right=null;
            nroot.head = root;
            nroot.tail = rlist.tail;
        }
        
        return nroot;
        
        
    }


    // Second method to flattening this above list, this one is an recursive approach
    // returns a newly created singly linked list
    public static void convert2(node root){
        if(root==null) return;
        lnode n = new lnode(root.val);
        if(lhead==null){
            lhead=n;
            tmp=lhead;
        }else{
            tmp.next = n;
            tmp = tmp.next;
        }
        convert(root.down);
        convert(root.right);
    }
    
}
