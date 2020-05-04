package M5D4;

public class MyLinkedList {
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        node1.add(node2);
        node1.add(node3);
        node1.show();
        Node.delete(node1);
        node1.show();
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }
    public static void delete(Node node){
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public void show(){
        Node temp=this;
        while (true){
            System.out.println(temp.toString());
            if(temp.next==null){
                break;
            }

            temp=temp.next;
        }
    }
    public void add(Node node){
        Node temp=this;
        while (true){
            if(temp.next==null){
                temp.next=node;
                break;
            }
            temp=temp.next;
        }

    }
    @Override
    public String toString(){
        return "Node="+
                val;
    }
}