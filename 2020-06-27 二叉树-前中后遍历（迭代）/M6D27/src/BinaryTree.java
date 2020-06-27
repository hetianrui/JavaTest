import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node node=new Node(2);
        Node node1=new Node(3);
        Node node2=new Node(4);
        Node node3=new Node(5);
        Node node4=new Node(6);
        Node node5=new Node(7);
        root.setLeft(node);
        root.setRight(node1);
        node.setLeft(node2);
        node.setRight(node3);
        node1.setLeft(node4);
        node1.setRight(node5);
        CreateR head=new CreateR(root);
        Iterator iterator=head.after().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
class CreateR{
    Node root;
    public CreateR(Node node){
        this.root=node;
    }
    public List before(){
        if(this.root==null){
            return new ArrayList();
        }else {
            return this.root.before();
        }
    }
    public List mid(){
        if(this.root==null){
            return new ArrayList();
        }else {
            return this.root.mid();
        }
    }
    public List after(){
        if(this.root==null){
            return new ArrayList();
        }else {
            return this.root.after();
        }
    }
}
class Node{
    private Node left;
    private Node right;
    private int val;
    public List<Node> before(){
        List<Node> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        stack.add(this);
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            if(temp!=null){
                if(temp.right!=null){
                    stack.add(temp.right);
                }
                if(temp.left!=null){
                    stack.add(temp.left);
                }
                stack.add(temp);
                stack.add(null);
            }else {
                list.add(stack.pop());
            }
        }
        return list;
    }
    public List<Node> mid(){
        List<Node> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        stack.add(this);
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            if(temp!=null){
                if(temp.right!=null){
                    stack.add(temp.right);
                }
                stack.add(temp);
                stack.add(null);
                if(temp.left!=null){
                    stack.add(temp.left);
                }

            }else {
                list.add(stack.pop());
            }
        }
        return list;
    }
    public List<Node> after(){
        List<Node> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        stack.add(this);
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            if(temp!=null){
                stack.add(temp);
                stack.add(null);
                if(temp.right!=null){
                    stack.add(temp.right);
                }
                if(temp.left!=null){
                    stack.add(temp.left);
                }

            }else {
                list.add(stack.pop());
            }
        }
        return list;
    }
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

    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public Node(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}