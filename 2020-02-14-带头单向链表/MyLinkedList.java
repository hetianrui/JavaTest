package TestCode;

public class MyLinkedList {
    Node head=new Node(0,"");
    public void add(Node val){//不管id的大小，无序插入
        Node temp=head;//拿一个临时变量指向头结点，因为头结点不能动
        while (true){
            if(temp.next==null){ //带头的单链表插入时是尾插，所以找到next为空的结点就是尾结点
                break;
            }
            temp=temp.next;
        }
        temp.next=val;
    }

    public void addbyOrder(Node val) {//按照id的大小，有序插入
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
            }else if(temp.next.id==val.id){
                System.out.println(temp.next.id+"这个位置已经有了，无法插入");
                break;
            }
                  temp=temp.next;
        }
    }

    public  void show() {
        Node temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
            System.out.println(temp.toString());

        }
    }

    public static void main(String[] args) {
        Node node1=new Node(1,"小明");
        Node node5=new Node(5,"小绿");
        Node node2=new Node(2,"小红");
        Node node3=new Node(3,"小蓝");
        Node node0=new Node(0,"小白");
        MyLinkedList list=new MyLinkedList();
        list.addbyOrder(node1);
        list.addbyOrder(node3);
        list.addbyOrder(node0);
        list.addbyOrder(node5);
        list.addbyOrder(node2);
        list.show();
    }
}
class Node{
    int id;
    String name;
    Node next=null;
    public Node(int id, String name){
        this.id=id;
        this.name=name;

    }
    public String toString(){
        return "id: "+id+" "+"name: "+name;
    }
}

