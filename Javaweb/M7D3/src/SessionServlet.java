import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionServlet extends BaseServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = session.getId();
        response.getWriter().write("sessionId: "+id);
        boolean aNew = session.isNew();
        response.getWriter().write("session is new ? "+aNew);


    }
    @Test
    public void test(){
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(5);
        ListNode l5=new ListNode(6);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        System.out.println(SessionServlet.addTwoNumbers(l1,null));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list=new ArrayList<>();
        ListNode temp1=l1;
        ListNode temp2=l2;
        while( temp1 != null && temp2 != null ){
            int count=0;
            if(temp1==null){
                count=temp2.val;
            }else if(temp2==null){
                count=temp1.val;
            }else{
                count=temp1.val+temp2.val;
            }
            int temp=count;
            if(count>10){
                count=count%10;
            }
            list.add(count);
            temp1=temp1.next;
            temp2=temp2.next;
            if(count!=temp){
                if(temp1!=null){
                    temp1.val=temp1.val+1;
                }else{
                    temp2.val=temp2.val+1;
                }
            }
        }
        ListNode l3=new ListNode(list.remove(0));
        ListNode temp3=l3;
        while(list.size()!=0){
            temp3.next=new ListNode(list.remove(0));
            temp3=temp3.next;
        }
        return l3;
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}