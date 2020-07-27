

class ListNode {
    int val;
     ListNode next;
    ListNode(int x) { val = x; }
 }
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int a[]=new int[count];
        int i=count-1;
        while(i>=0){
            a[i--]=head.val;
            head=head.next;
        }
        return a;
    }
}