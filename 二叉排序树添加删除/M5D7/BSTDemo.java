package M5D7;

public class BSTDemo {
    public static void main(String[] args) {
        Node head=new Node(7);
        Node node1=new Node(3);
        Node node2=new Node(10);
        Node node3=new Node(1);
        Node node4=new Node(5);
        Node node5=new Node(9);
        Node node6=new Node(12);
        Node node7=new Node(2);
        Node node=new Node(8);
        CreateTree root=new CreateTree(head);
        root.add(node1);
        root.add(node2);
        root.add(node3);
        root.add(node4);
        root.add(node5);
        root.add(node6);
        root.add(node7);
        root.mid();
        System.out.println("***************");
//        root.delete(node7);
//        root.delete(node3);
//        root.delete(node6);
//        root.mid();
        root.delete(node1);
        root.mid();


    }
}
class CreateTree{
    Node root;
    public CreateTree(Node node){
        this.root=node;
    }
    public void add(Node node){
        if(root==null){
            root=node;
            return;
        }else {
            root.add(node);
        }
    }
    public void delete(Node node){
        if(root==null ){
            return;
        }else {
            root.delete(node);
        }
    }
public Node Search(Node node){
        if(root==null || node==null){
            return null;
        }else {
                return root.search(node);
            }
        }


    public Node SearchParent(Node node){
        if(root==null){
            return null;
        }else {
            return root.searchParent(node);
        }
    }

    public void mid() {
        if (root==null){
            System.out.println("Empty tree");
            return;
        }else {
            root.mid();
        }
    }
 public void midSearch(){
        if(root.left!=null&& root.right!=null){
            System.out.println(root.left.midSearch(root.left,root.right));
        }
 }
}
class Node{
    Node left;
    Node right;
    int val;
    public Node(int val ){
        this.val=val;
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
    public Node midSearch(Node left,Node right){
      if(this.val>left.val && this.val<right.val) {
          return this;
      }
        Node temp=null;
      if(this.left!=null){
          temp=this.left.midSearch(left,right);
      }
      if(temp!=null){
          return temp;
      }
      if( this.right!=null){
            temp=this.right.midSearch(left,right);
      }
        if(temp!=null){
            return temp;
        }else {
          return null;
        }
    }

    public void delete(Node node) {
        Node targetNode = search(node);
        Node parent = searchParent(targetNode);
        if (targetNode.left == null && targetNode.right == null) {//删除叶子节点
            if (parent.left != null && parent.left.val == targetNode.val) {
                parent.left = null;
            } else if (parent.right != null && parent.right.val == targetNode.val) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {//有两颗子树
            Node temp=targetNode.left.midSearch(targetNode.left,targetNode.right);
            Node tempparent=searchParent(temp);
            targetNode.val=temp.val;
            if(tempparent.left==temp){
                tempparent.left=null;
            }else {
                tempparent.right=null;
            }
        } else {//有一颗子树
            if (parent != null) {
                if (targetNode.left != null && parent.left == targetNode) {
                    parent.left = targetNode.left;
                } else if (targetNode.right != null && parent.left == targetNode) {
                    parent.left = targetNode.right;
                } else if (targetNode.left != null && parent.right == targetNode) {
                    parent.right = targetNode.left;
                } else if (targetNode.right != null && parent.right == targetNode) {
                    parent.right = targetNode.right;
                }
            } else {
                if (targetNode.left != null) {
                    targetNode.val = targetNode.left.val;
                    targetNode.left = null;
                } else {
                    targetNode.val = targetNode.left.val;
                    targetNode.right = null;
                }
            }
        }

    }
    /**
     *
     * @param node 目标节点
     */
    public Node searchParent(Node node){
        if(node==null){
            return null;
        }
        if (this.val == node.val) {
            return null;
        } else if ((this.left != null && this.left.val == node.val) ||
                (this.right != null && this.right.val == node.val)) {
            return this;
        } else {
            if (this.val > node.val && this.left != null) {
                return this.left.searchParent(node);
            } else if (this.val <= node.val && this.right != null) {
                return this.right.searchParent(node);
            }else {
                return null;
            }

        }

    }

    /**
     *
     * @param node 目标节点
     * @return
     */
    public Node search(Node node){
        if(this.val==node.val){
            return this;
        }
        if((this.val>node.val && this.left==null) ||(this.val<node.val && this.right==null)){
            return null;
        }else if(this.val>node.val && this.left!=null){
              return this.left.search(node);
        }else if(this.val<node.val && this.right!=null){
            return this.right.search(node);
        }else {
            return null;
        }

    }
   public void add(Node node){
        if(node.val < this.val){
            if(this.left==null){
                this.left=node;
                return;
            }else {
                this.left.add(node);
            }
        }else if(this.val <= node.val){
            if(this.right==null){
                this.right=node;
                return;
            }else {
                this.right.add(node);
            }
        }

   }
    @Override
    public String toString(){
        return "Node={id="+val+"}";
    }
}