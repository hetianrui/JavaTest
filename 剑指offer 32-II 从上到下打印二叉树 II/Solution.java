import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> res=new LinkedList();
        List<List<Integer>> list=new ArrayList<>();
        res.add(root);
        res.add(null);
        int count=0;
        List lists=new ArrayList();
        while(res.size()!=0){
            TreeNode temp=res.poll();
            if(temp!=null){
                if(temp.left!=null){
                    res.add(temp.left);
                }
                if(temp.right!=null){
                    res.add(temp.right);
                }
                if(res.peek()==null){
                    res.add(null);
                }
                lists.add(temp.val);
            }else{
                if(lists.size()!=0){
                    list.add(count++,lists);
                    lists=new ArrayList();
                }
            }

        }
        return list;

    }
} 