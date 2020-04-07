public class MyLinkedList {
    public static void main(String[] args) {
    Node root=new Node(9,"");
    Node node1=new Node(6,"tom");
        Node node2=new Node(5,"sam");
        Node node3=new Node(2,"lol");
        Node node4=new Node(3,"khan");
        Node node5=new Node(10,"");
        root.insertByOrder(node1);
        root.insertByOrder(node2);
        root.insertByOrder(node3);
        root.insertByOrder(node4);
        root.insertByOrder(node5);
        root.show();
        System.out.println("**********************");
        root.delete(node3);
        root.delete(node5);
        root.delete(node2);
        root.delete(node4);
        root.delete(node1);
        root.delete(node1);
        root.show();
    }
}
class Node{
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    Node next;
    public Node(int id,String name){
        this.id=id;
        this.name=name;
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
    public void insertByOrder(Node node){
        Node temp=this;
        while (true){
            if(temp.next==null){
                temp.next=node;
                break;
            }
            if(temp.next.id>node.id){
                Node count=temp.next;
                temp.next=node;
                node.next=count;
                break;
            }
            temp=temp.next;
        }
    }
    public void delete(Node node){
        if(this.next==null){
            System.out.println("has been null");
            return;
        }
        Node temp=this;
        while (true){
            if(temp.next.id==node.id){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }
    public void show(){
        if(this.next==null){
            System.out.println("Null");
            return;
        }
        Node temp=this.next;
        while (true){
            System.out.println(temp.toString());
           if(temp.next==null){
               break;
           }
            temp=temp.next;
        }
    }
}