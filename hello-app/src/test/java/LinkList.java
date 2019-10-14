import java.util.ArrayList;
class Node{//结点类
    int value;//保存节点中的数据
    Node next;//指向下一个结点的引用
    Node prev;
    Node last;
    public Node(int value){
        this.value=value;
        this.next=null;
    }
}

public class LinkList {
    public static void display(Node head){
           Node cur=head;
          while(cur!=null){
              System.out.print(cur.value);
              cur=cur.next;
          }

    }
   /* public int polllast(){

    }*/

    //头插
    public static Node PushFront(Node head,int value){
        Node node=new Node(value);
        node.next=head;
        return node;

    }
    //尾插
    public static Node pushBack(Node head,int value){
        Node last=new Node(value);
        getLast(head).next=last;
        last.next=null;
        return last;
    }
    public static Node getLast(Node head){
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
           Node head=null;
           LinkList list=new LinkList();
           //list.addlast("c");
           head=PushFront(head,10 );
           head=PushFront(head,20 );
           head=PushFront(head,30 );
           head=PushFront(head,40 );
           display(head);


    }
}
