
/**
 * 
 * Given  list of nodes,we need to sort the linnked list in TC:- o(n*logn) and constant space complexity; 
 * 
 */

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int v){
//         this.val = v;
//         this.next = null;
//     }
// }


public class MergeSort_LL {
    public static void main(String[] args) {
        MergeSort_LL ms = new MergeSort_LL();
        ListNode root = new ListNode(1);
        root.next = new ListNode(5);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        ListNode sorted = ms.sort(root);
        ms.show(sorted);
    }

    public ListNode sort(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null){
            fast = fast.next;
            if(fast==null) break;
            fast = fast.next;
            if(fast==null) break;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        if(head2==null) return head;
        slow.next = null;
        head = sort(head);
        head2 = sort(head2);
        return merge(head,head2);
    }

    public ListNode merge(ListNode head1, ListNode head2){
        System.out.println("in merge process");
        System.out.print("head1 => ");
        show(head1);
        System.out.print("head2 => ");
        show(head2);
        System.out.println();
        ListNode head=null,tmp=null;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                if(head==null) {
                    head=head1;
                    tmp=head;
                }
                else{
                    tmp.next = head1;
                    tmp=tmp.next;
                }
                head1 = head1.next;
            }else{
                if(head==null){
                    head = head2;
                    tmp=head;
                }
                else{
                    tmp.next = head2;
                    tmp = tmp.next;
                }
                head2 = head2.next;
            }
        }
        while(head1!=null){
            tmp.next = head1;
            tmp=tmp.next;
            head1 = head1.next;
        }

        while(head2!=null){
            tmp.next = head2;
            tmp = tmp.next;
            head2 = head2.next;
        }
        return head;
    }

    public void show(ListNode root){
        while(root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
    }
}


