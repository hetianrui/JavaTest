
class TreeNode{
  TreeNode left;
  TreeNode right;
  int val;
  public TreeNode(int val){
      this.val=val;
  }
}
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        t1.val=t1.val+t2.val;
        if(t1.left!=null || t2.left!=null){
            t1.left=mergeTrees(t1.left,t2.left);
        }
        if(t1.right!=null || t2.right!=null){
            t1.right=mergeTrees(t1.right,t2.right);
        }

        return t1;
    }
}