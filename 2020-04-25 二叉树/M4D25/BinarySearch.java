package M4D25;

public class BinarySearch {
    public static void main(String[] args) {
        Node head=new Node(1);
        Create root=new Create(head);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        Node node6=new Node(6);
        head.setLeft(node1);
        head.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        root.before();
        System.out.println("********");
        root.BeforeSearch(node6);
//        System.out.println("********");
//        root.mid();
//        System.out.println("********");
//        root.after();
    }
}
class Create{
    private Node root;

    public Create(Node root) {
        this.root = root;
    }
    public void BeforeSearch(Node node){
        if(root!=null){
            System.out.println(root.BeforeSearch(node));
        }else {
            System.out.println("空树，无法查找");
        }
    }
    public void before(){
        if(root!=null){
            root.before();
        }else {
            System.out.println("空树");
        }
    }
    public void mid(){
        if(root!=null){
            root.mid();
        }else {
            System.out.println("空树");
        }
    }
    public void after(){
        if(root!=null){
            root.after();
        }else {
            System.out.println("空树");
        }
    }
}
class Node{
    private Node left;
    private Node right;
    private int id;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int id) {
        this.id = id;
    }
public Node BeforeSearch(Node node){
        if(this.id==node.id){
//            System.out.println(node.id+"存在");
            return node;
        }
        Node temp=null;
        if(this.left!=null){
            temp=this.left.BeforeSearch(node);
        }
        if(temp!=null){
            return temp;
        }
        if(this.right!=null){
            temp=this.right.BeforeSearch(node);
        }
        if(temp!=null){
            return temp;
        }
        return null;
}
    public void before(){
    System.out.println(this);
    if(this.left!=null){
        this.left.before();
    }
    if(this.right!=null){
        this.right.before();
    }
}
public void mid(){

    if(this.left!=null){
        this.left.mid();
    }
    System.out.println(this);
    if(this.right!=null){
        this.right.mid();
    }
}
    public void after(){

        if(this.left!=null){
            this.left.after();
        }

        if(this.right!=null){
            this.right.after();
        }
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}