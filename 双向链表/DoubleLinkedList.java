package TestCode;

public class DoubleLinkedList {
Node head=new Node(0);
public void add(Node val){
    Node temp=head;
    while (true){
        if(temp.next==null){
            temp.next=val;
            val.pre=temp;
            break;
        }
        temp=temp.next;
    }
}
public void addByorder(Node val){
    Node temp=head;
    while (true){
        if(temp.next==null){
            temp.next=val;
            val.pre=temp;
            break;
        }
        if(temp.next.id>val.id){
            val.next=temp.next;
            temp.next=val;
            val.pre=temp;
            val.next.pre=val;
            break;
        }
        temp=temp.next;
    }
}

    public void delete(int val) {
        Node temp = head.next;
        while (true) {
            if (temp.id == val) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp=temp.next;
        }
    }
public void show(){
    Node temp=head;
    while (true){
        if(head.next==null){
            System.out.println("链表为空");
            break;
        }
        if(temp.next==null){
            break;
        }
       temp=temp.next;
        System.out.println(temp.toString());
    }
}
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        DoubleLinkedList list=new DoubleLinkedList();
        list.addByorder(d);
        list.addByorder(a);
        list.addByorder(b);
        list.addByorder(c);
        list.delete(4);
        list.delete(1);
        list.show();
    }
}
class Node{
    public int id;
    Node next;
    Node pre;
    public Node(int id){
        this.id=id;

    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}