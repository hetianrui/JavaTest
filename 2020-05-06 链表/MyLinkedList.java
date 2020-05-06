package TestCode;

public class MyLinkedList {
    static Node head=new Node(0,"");
    public void addByorder(Node val){
        Node temp=head;
        while (true){
            if(temp.next==null){
                temp.next=val;
                break;
            }
            if(temp.next.id>val.id){
                val.next=temp.next;
                temp.next=val;
                break;
            }
            temp=temp.next;
        }

    }
    public void reverse(Node head){
        Node nhead=new Node(0,"");
        Node cur=head.next;
        Node newNext=nullw;
        while (cur!=null){
            newNext=cur.next;
            cur.next=nhead.next;
            nhead.next=cur;
            cur=newNext;
        }
        head.next=nhead.next;
    }
    public void show(){
        Node temp=head;
        if(head.next==null){
            System.out.println("链表为空");
        }
        while (true){
            if(temp.next==null){
                break;
            }
            temp= temp.next;
            System.out.println(temp);
        }
    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        Node a=new Node(1,"Sna");
        Node b=new Node(2,"Sam");
        Node c=new Node(3,"Son");
        list.addByorder(a);
        list.addByorder(c);
        list.addByorder(b);
        list.show();
        System.out.println("***************");
        list.reverse(head);
        list.show();
    }

}
class Node{
    int id;
    String name;
    Node next;
    public Node(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}