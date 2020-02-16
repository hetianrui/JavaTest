package TestCode;

public class MyLinkedList {
    Node head=new Node(0,"");
    public void add(Node val){//无序插入
        Node temp=head;
        while (true){//遍历寻找最后一个结点
            if(temp.next==null){//找到最后一个结点，尾插
              break;
            }
            temp= temp.next;
            if(temp.id==val.id){
                System.out.println(temp.id+"位置有了，无法插入");
                return;
            }
        }
        temp.next=val;

    }
    public void addbyorder(Node val){
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
            if(temp.next.id==val.id){
                System.out.println(val.id+"位置有人了，无法插入");
                break;
            }
            temp= temp.next;
        }
    }
    public void show(){
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
        Node node1=new Node(1,"Tom");
        Node node2=new Node(2,"Sam");
        Node node3=new Node(3,"Selina");
        //Node node5=new Node(3,"Selina");
        Node node4=new Node(4,"Jhon");
        MyLinkedList list=new MyLinkedList();
        list.addbyorder(node4);
        list.addbyorder(node3);
        list.addbyorder(node2);
        list.addbyorder(node1);
        list.show();
    }
}
class Node{
      int id;
      String name;
    Node next=null;
    public Node(int id,String name){
        this.id=id;
        this.name=name;
    }
    public String toString(){
        return "id="+id+","+"name="+name;
    }
}