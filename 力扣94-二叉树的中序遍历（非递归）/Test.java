import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        System.out.println(TreeNode.mid(root));
    }

}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }

    public static List mid(TreeNode root){
        List<TreeNode> Output=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return Output;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp!=null){
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                stack.push(null);
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }else {
                Output.add(stack.pop());
            }
        }
        return Output;
    }
}