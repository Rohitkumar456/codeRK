/**
 * Given a singly linked list A

    A: A0 → A1 → … → An-1 → An 
    reorder it to:

    A0 → An → A1 → An-1 → A2 → An-2 → … 
    You must do this in-place without altering the nodes' values.
 */
import java.util.*;
 class ListNode{
     public int val;
     public ListNode next;

     ListNode(int x) {
         this.val = x;
         this.next = null;
     }
 }
public class ReOrderList {
    public static void main(String[] args) {
        
    }

    public ListNode reorderList(ListNode A) {
        Stack<ListNode>st = new Stack<>();
        ListNode tmp = A;
        while(tmp!=null){
            st.push(tmp);
            tmp = tmp.next;
        }
        tmp=A;
        int n = st.size();
        int t = n/2;
        while(t-->0){
            // System.out.print("t="+t);
            ListNode nxt = tmp.next;
            ListNode x = st.pop();
            tmp.next = x;
            if(nxt!=x)
            x.next = nxt;
            tmp=nxt;
        }
        tmp.next = null;
        return A;
    }
}
