import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            if (temp != null) {
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
                list.add(temp.val);
            }
        }
        int i = list.size();
        int a[] = new int[i];
        for (int j = 0; j < a.length; j++) {
            a[j]=list.remove(0);
        }
        return a;
    }
}