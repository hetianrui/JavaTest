


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return mirror(root, root);
    }

    public boolean mirror(TreeNode l, TreeNode r) {
        if (l == null && r != null) {
            return false;
        }
        if (l != null && r == null) {
            return false;
        }
        if (l == null && r == null) {
            return true;
        }
        return (l.val == r.val) && mirror(l.left, r.right) && mirror(l.right, r.left);
    }
} 