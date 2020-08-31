/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode l1=head;
        ListNode l2=head.next;
        ListNode l3=l2.next;
        l1.next=null;
        while(l2!=null){
        l2.next=l1;
        l1=l2;
        l2=l3;
        if(l3!=null){
            l3=l3.next;
        }
        }
        return l1;
    }
}