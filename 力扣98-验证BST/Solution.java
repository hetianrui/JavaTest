package htr.config;



class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    /*List<Integer> list=new ArrayList<>();
    public List mid(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left!=null){
            mid(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            mid(root.right);
        }
        return list;
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=mid(root);
        if(list==null){
            return true;
        }
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }*/
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}