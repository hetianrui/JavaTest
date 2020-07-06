
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1==null || l2==null ){
            return l1==null ? l2:l1;
        }
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode list=new ListNode(0);
        ListNode temp3=list;
        while( temp1 != null || temp2 != null ){
            int count=0;
            if(temp1==null){
                count=temp2.val;
            }else if(temp2==null){
                count=temp1.val;
            }else{
                count=temp1.val+temp2.val;
            }
            int temp=count;
            if(count>=10){
                count=count%10;
            }
            temp3.next=new ListNode(count);
            temp3=temp3.next;
            if(temp1!=null){
                temp1=temp1.next;
            }
            if(temp2!=null){
                temp2=temp2.next;
            }

            if(count!=temp){
                if(temp1!=null){
                    temp1.val=temp1.val+1;
                }else{
                    if(temp2!=null){
                        temp2.val=temp2.val+1;
                    }else{
                        temp3.next=new ListNode(1);
                    }
                }
            }
        }
        return list.next;
    }
}
