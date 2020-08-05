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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return list;
        }
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            if (temp != null) {
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
                if (que.peek() == null) {
                    que.add(null);
                }
                res.add(temp.val);
            } else {
                if (res.size() != 0) {
                    if (list.size() % 2 != 0) {
                        List<Integer> tmp = new ArrayList<>();
                        int s = res.size();
                        for (int i = s - 1; i >= 0; i--) {
                            tmp.add(res.remove(i));
                        }
                        list.add(tmp);
                    } else {
                        list.add(res);
                    }
                    res = new ArrayList<>();
                }
            }
        }
        return list;
    }
}