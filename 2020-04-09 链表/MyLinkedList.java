public class MyLinkedList {
    public static void main(String[] args) {
    Node root=new Node(0);
        Node node1=new Node(6);
        Node node2=new Node(9);
        Node node3=new Node(3);
        root.insertByOrder(node1);
        root.insertByOrder(node2);
        root.insertByOrder(node3);
        root.show();
        System.out.println("******************");
        root.detele(node3);
        root.detele(node1);
        root.detele(node2);
        root.detele(node2);
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
  public void insertByOrder(Node node){
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
  public void detele(Node node){
        Node temp=this;
        if(temp.next==null){
            System.out.println("can not delete");
            return;
        }
        while (true){
            if(temp.next.id==node.id){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
            if(temp.next==null){
                System.out.println("该节点不存在");
                break;
            }
        }
  }
  public void show() {
      Node temp = this;
      if (temp.next == null){
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