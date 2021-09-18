
/**
 * 
 * Given a singly linked list , you need to find the length of longest palindromic sublist.
 * 
 */



public class LengthOfLongestPalindromicSublist {
    private class ListNode{
        public int val;
        public ListNode next;
   
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        LengthOfLongestPalindromicSublist llp = new LengthOfLongestPalindromicSublist();
        ListNode root = llp.createList();
        int ans = llp.longestPalindromicList(root);
        System.out.println(ans);
    }

    public int longestPalindromicList(ListNode root){
        if(root.next==null) return 1;
        int ans=0;
        ListNode cur,nxt,prev;
        cur = root.next;
        root.next=null;
        prev = root;
        while(cur!=null){
            nxt = cur.next;
            int even = palindroicLength(prev, cur);
            int odd = palindroicLength(prev, nxt)+1;
            ans = Math.max(ans, Math.max(even,odd));
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return ans;
    }

    public int palindroicLength(ListNode h1, ListNode h2){
        int len=0;
        while(h1!=null&& h2!=null){
            if(h1.val!=h2.val) return len;
            len+=2;
            h1 = h1.next;
            h2 = h2.next;
        }
        return len;
    }


    public ListNode createList(){
        ListNode root = new ListNode(2);
        root.next = new ListNode(3);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        // root.next.next.next.next = new ListNode(2);
        // root.next.next.next.next.next = new ListNode(1);
        // root.next.next.next.next.next.next = new ListNode(2);
        return root;
    }
}
