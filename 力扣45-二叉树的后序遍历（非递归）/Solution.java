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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null){
            stack.add(root);
        }else{
            return list;
        }
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp!=null){
                stack.add(temp);
                stack.add(null);
                if(temp.right!=null){
                    stack.add(temp.right);
                }
                if(temp.left!=null){
                    stack.add(temp.left);
                }

            }else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}