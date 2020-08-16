/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ListNode head=new ListNode(0);//创建头节点
        // ListNode cur = head;
        // while(l1!=null&&l2!=null){
        //     if(l1.val<l2.val){
        //         cur.next=l1;
        //         l1=l1.next;
        //         cur=cur.next;
        //     }else{
        //         cur.next=l2;
        //         l2=l2.next;
        //         cur=cur.next;

        //     }
        // }
        // cur.next=(l1==null? l2:l1);
        // return head.next;
        ListNode temp=new ListNode(0);
        ListNode cur=temp;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                cur.next=l2;
                l2=l2.next;
            }else{
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        while(l1!=null){
            cur.next=l1;
            l1=l1.next;
            cur=cur.next;
        }
        while(l2!=null){
            cur.next=l2;
            l2=l2.next;
            cur=cur.next;
        }
        return temp.next;
      }
}