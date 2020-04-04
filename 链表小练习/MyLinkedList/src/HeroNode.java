
public class HeroNode {
    public static void main(String[] args) {
        Node root=new Node(0,"");
        Node node1=new Node(1,"Tom");
        Node node2=new Node(2,"Sam");
        Node node0=new Node(0,"lol");
        Node node3=new Node(3,"Jim");
        Node node4=new Node(4,"OOM");
        root.insert(node1);
        node1.insert(node2);
        node2.insert(node4);
        root.show();
        System.out.println("++++++++++++++++++");
       root.insertByorder(node3);
       root.insertByorder(node0);
        root.show();
    }

}

class Node{
    private Node next;
    private int id;
    private String name;

    public void insert(Node node) {
        Node temp = this;
        if (this == null)
            System.out.println("null");
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    public void insertByorder(Node node){
        Node temp=this;
        while (true){
            if(temp.next.id>node.id){
                break;
            }
            temp=temp.next;
        }
        Node count=temp.next;
        temp.next=node;
        node.next=count;
    }
    public void delete(int id ){
        Node temp=this;
        if(temp.next==null) {
            System.out.println("Error to delete");
            return;
        }
        while (true){
            if(temp.next.id==id){
                break;
            }
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    public void show(){
        Node temp = this;
        while (true) {
            if (temp.next == null) {
                   break;
            } else {
                temp = temp.next;
                System.out.println(temp.toString());
            }
        }
    }
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}