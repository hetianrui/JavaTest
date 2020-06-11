public class MyLinkedList {
    public static void main(String[] args) {
        Node root=new Node(0,"");
        Create node=new Create(root);
        Node node1=new Node(1,"Sam");
        Node node2=new Node(2,"Link");
        Node node3=new Node(3,"Poll");
        Node node4=new Node(4,"Poll");
        node.addByorder(node2);
        node.addByorder(node1);
        node.addByorder(node3);
        node.show();
        node.delete(node4);
        node.show();

    }
}
class Create{
    Node root;
    public Create(Node node){
        this.root=node;
    }
    public void add(Node node){
        if(root.next==null){
            root.next=node;
        }else {
            root.add(node);
        }
    }
    public void addByorder(Node node){
        if(root.next==null){
            root.next=node;
        }else {
            root.addbyorder(node);
        }
    }
    public void show(){
        if (root.next==null){
            System.out.println("Empty");
            return;
        }
        root.show();
    }
    public void delete(Node node){
        if(root.next==null){
            System.out.println("Empty");
            return;
        }else {
            root.delete(node);
        }
    }
}
class Node{
    int id;
    String name;
    Node next;
    public Node(){

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
    public void addbyorder(Node node){
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
                System.out.println("此节点不存在");
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
        Node temp=this.next;
        while (true){
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp=temp.next;
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
}