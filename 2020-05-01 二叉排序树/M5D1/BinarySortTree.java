package M5D1;

public class BinarySortTree {
    public static void main(String[] args) {
        int []arr={7,3,10,12,5,1,9};

        CreateTree createTree=new CreateTree(null);
        for(int i=0;i<arr.length;i++){
            createTree.add(new Node(arr[i]));
        }
        createTree.midOrder();

    }
}
class CreateTree{
    Node root;
    public CreateTree(Node node){
        this.root=node;
    }
    public void midOrder(){
        if(root==null){
            System.out.println("tree is empty.");
            return;
        }else {
            root.midOrder();
        }
    }
    public void add(Node node){
        if(root==null){
            root=node;
            return;
        }else {
            root.add(node);
        }

    }
}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public void midOrder(){
        if(this.left!=null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midOrder();
        }
    }
    public void add(Node node){
        if(node==null){
            System.out.println("null,can not insert");
            return;
        }
        if(node.val<this.val){
            if(this.left == null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }
}