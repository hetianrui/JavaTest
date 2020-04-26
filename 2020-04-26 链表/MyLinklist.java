public class MyLinklist {
    public static void main(String[] args) {
        Node root = new Node(0, "");
        Node node0= new Node(2, "");
        Node node1 = new Node(5, "");
        Node node2 = new Node(3, "");
        Node node3 = new Node(9, "");
        Node node4 = new Node(7, "");
        root.insertByOrder(node1);
        root.insertByOrder(node2);
        root.insertByOrder(node3);
        root.insertByOrder(node4);
        root.insertByOrder(node0);
        root.show();
        root.delete(node0);
        root.delete(node3);
        root.delete(node2);
        root.delete(node4);
        root.delete(node1);
        root.delete(root);
        System.out.println("*******************");
        root.show();

    }
}

class Node {
    private int id;
    private String name;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public void insert(Node node) {
        Node temp = this;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void insertByOrder(Node node) {
        Node temp = this;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            if (temp.next.id > node.id) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(Node node) {
        Node temp = this;
        while (true) {
            if (temp.next == null) {
                System.out.println("null,can not to delete");
                break;
            }
            if (temp.next.id == node.id) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void show() {
        Node temp = this;
        while (true) {
            if(temp.next==null){
                System.out.println("null" );
                break;
            }
            System.out.println(temp.next.toString());
            temp = temp.next;
            if (temp.next == null) {
                break;
            }
        }
    }
}