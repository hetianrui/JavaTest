import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(2);
        root.BSTInsert(node1);
        root.BSTInsert(node2);
        root.BSTInsert(node3);
        root.BSTInsert(node4);
        root.BSTInsert(node5);
        root.BSTInsert(node6);
        root.BSTInsert(node7);
        root.mid();
        root.delete(node6);
        //System.out.println(TreeNode.getParent(node7,root));
        System.out.println("************");
        root.mid();
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getParent(TreeNode node, TreeNode root) {//目标节点，根节点
        if (root.val == node.val) {
            return null;
        }
        if (root.val > node.val && root.left != null) {
            if (root.left.val == node.val) {
                return root;
            } else {
                return getParent(node, root.left);
            }
        }
        if (root.val < node.val && root.right != null) {
            if (root.right.val == node.val) {
                return root;
            } else {
                return getParent(node, root.right);
            }
        }
        return null;
    }

    public void delete(TreeNode node) {
        if (node.left == null && node.right == null) {//删除叶子节点
            TreeNode temp = getParent(node, this);
            if (temp.left!=null && temp.left.val == node.val) {
                temp.left = null;
            } else if (temp.right!=null && temp.right.val == node.val) {
                temp.right = null;
            }
        } else if (node.left != null && node.right != null) {//删除有两个子树的节点

        } else {//删除有一个子树的节点
            TreeNode temp = getParent(node, this);
            if (temp.left.val==node.val) {
                if(node.left==null){
                    temp.left=node.right;
                }else {
                    temp.left=node.left;
                }
            } else if (temp.right.val == node.val) {
                if(node.left==null){
                    temp.right=node.right;
                }else {
                    temp.right=node.left;
                }
            }
        }
    }

    public void BSTInsert(TreeNode root) {
        if (this == null) {
            return;
        }
        if (root.val > this.val) {
            if (this.right == null) {
                this.right = root;
            } else {
                this.right.BSTInsert(root);
            }
        } else if (root.val < this.val) {
            if (this.left == null) {
                this.left = root;
            } else {
                this.left.BSTInsert(root);
            }
        }
    }

    public void mid() {
        if (this.left != null) {
            this.left.mid();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.mid();
        }
    }

    @Override
    public String toString() {
        return "val=" + val;
    }

}