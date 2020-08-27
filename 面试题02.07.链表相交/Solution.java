/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if(headB==null || headA==null){
        //     return null;
        // }
        // int count1=1;
        // int count2=1;
        // ListNode l1=headA;
        // ListNode l2=headB;
        // while(l1!=null){
        //     l1=l1.next;
        //     count1++;
        // }
        // while(l2!=null){
        //     l2=l2.next;
        //     count2++;
        // }
        // int res=0;
        // if(count1>count2){
        //     res=count1-count2;
        //     l1=headA;
        //     l2=headB;
        //     while(res!=0){
        //         l1=l1.next;
        //         res--;
        //     }
        // }else if(count2>count1){
        //     res=count2-count1;
        //     l2=headB;
        //     l1=headA;
        //     while(res!=0){
        //         l2=l2.next;
        //         res--;
        //     }
        // }else{
        //     l1=headA;
        //     l2=headB;
        // }
        // while(l1!=null && l2!=null){
        //     if(l1==l2){
        //         return l1;
        //     }else{
        //         l1=l1.next;
        //         l2=l2.next;
        //     }
        // }
        // return null;
        if(headB==null || headA==null){
            return null;
        }
        ListNode l1=headA;
        ListNode l2=headB;
        while(l1!=l2){
            l1= l1==null ? headB:l1.next;
            l2= l2==null ? headA:l2.next;
        }
        return l1;
    }
}