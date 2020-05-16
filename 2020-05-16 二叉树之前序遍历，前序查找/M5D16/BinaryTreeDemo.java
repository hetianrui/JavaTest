package M5D16;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.left=node2;
        root.right=node3;
        node2.left=node4;
        node2.right=node5;
        CreateTree tree=new CreateTree(root);
        tree.before();

        System.out.println("***************");
       tree.beforeSearch(node5);
    }
}
class CreateTree{
    Node root;
    public CreateTree(Node node){
        this.root=node;
    }
    public void before(){
        if(root!=null){
            root.before();
        }else {
            System.out.println("tree is empty.");
        }
    }
    public void beforeSearch(Node node){
        if(root!=null){
            System.out.println(root.beforeSearch(node));
        }else {
            System.out.println("tree is empty.");
        }
    }

}
class Node{
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
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

    public Node beforeSearch(Node node){
        if(this.val==node.val){
            return this;
        }
        Node temp=null;
        if(this.left!=null){
            temp=this.left.beforeSearch(node);
        }
        if(temp!=null){
            return temp;
        }
        if(this.right!=null){
            temp=this.right.beforeSearch(node);
        }
        return temp;
    }
}