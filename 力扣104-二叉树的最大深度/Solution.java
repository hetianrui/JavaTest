
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
public class Solution {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        System.out.println(maxDepth(n1));
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int countleft = 0;
        int countright = 0;
        if (root.left != null) {
            countleft = maxDepth(root.left);
        }
        if (root.right != null) {
            countright = maxDepth(root.right);
        }
        return Math.max(countleft, countright) + 1;
    }
}