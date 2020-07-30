/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        // if(root==null){
        //     return null;
        // }
        // return mir(root,new TreeNode(root.val));
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    
    // public TreeNode mir(TreeNode l,TreeNode r){
    //      if(l==null){
    //         return null;
    //     }
    //     if(l.left!=null){
    //         r.right=new TreeNode(l.left.val);
    //     }
    //     if(l.right!=null){
    //         r.left=new TreeNode(l.right.val);
    //     }
    //     mir(l.left,r.right);
    //     mir(l.right,r.left);
    //     return r;
    // }
}