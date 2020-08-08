
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res=new ListNode(0);
        res.next=head;
        ListNode l1=res;
        ListNode l2=res;
        for(int i=1;i<=n+1;i++){
            l1=l1.next;
        }
        while(l1!=null){
            l1=l1.next;
            l2=l2.next;
        }
        l2.next=l2.next.next;
        return res.next;
    }
}