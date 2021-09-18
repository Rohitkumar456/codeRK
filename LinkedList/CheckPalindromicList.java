

/**
 * 
 * Given a singly linked list, we need to check weatherthe given list is palindromic or not.
 * 
 * 
 */



public class CheckPalindromicList {
    private class ListNode{
        public int val;
        public ListNode next;
   
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CheckPalindromicList cpl = new CheckPalindromicList();
        ListNode root = cpl.createList();
        boolean ans = cpl.isPalindromic(root);
        System.out.println(ans);
    }

    public boolean isPalindromic(ListNode root){
        if(root.next==null) return true;
        int size = 0;
        ListNode cur=root,prev,nxt;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        int half = size/2;
        cur=root.next;
        root.next=null;
        prev=root;
        while(--half!=0){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        if(size%2==0){
            return checkP(prev, cur);
        }else return checkP(prev, cur.next);

    }

    public boolean checkP(ListNode h1,ListNode h2){
        while(h1!=null&&h2!=null){
            if(h1.val!=h2.val) return false;
            h1=h1.next;
            h2=h2.next;
        }
        return true;
    }

    public ListNode createList(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        return root;
    }
}
