import org.omg.CORBA.NO_IMPLEMENT;

public class MyLinkedList {
    public static void main(String[] args) {
    Node root=new Node(0);
        Node node1=new Node(8);
        Node node2=new Node(6);
        Node node3=new Node(1);
        root.insertByorder(node1);
        root.insertByorder(node2);
        root.insertByorder(node3);
        root.delete(node3);
        root.delete(node1);
        root.delete(node2);
        root.delete(node2);
        root.show();
    }
}
class Node{
private int id;
Node next;
public Node(int id){
    this.id=id;
}
public void insert(Node node){
    Node temp=this;
    while (true){
        if(temp.next==null){
            temp.next=node;
            break;
        }
        temp=temp.next;
    }
}
public void insertByorder(Node node){
    Node temp=this;
    while (true){
        if(temp.next==null){
            temp.next=node;
            break;
        }
        if(temp.next.id>node.id){
            node.next=temp.next;
            temp.next=node;
            break;
        }
        temp=temp.next;
    }
}
public void delete(Node node){
    Node temp=this;
    while (true){
        if(temp.next==null){
            System.out.println("has been empty,can not null");
            break;
        }
        if(temp.next.id==node.id){
            temp.next=temp.next.next;
            break;
        }
        temp=temp.next;
    }
}
public void show(){
    Node temp=this;
    if(temp.next==null){
        System.out.println("null");
        return;
    }
    while (true){
        System.out.println(temp.next.toString());
        temp=temp.next;
        if(temp.next==null){
            break;
        }
    }
}
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}