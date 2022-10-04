package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        backtracking(0, root);
        return res;
    }

    public void backtracking(int curSum, TreeNode root) {
        if (root == null) return;
        curSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum == target) res.add(new ArrayList<>(path));
            return;
        }
        backtracking(curSum, root.left);
        if (root.left != null) path.remove(path.size() - 1);
        backtracking(curSum, root.right);
        if (root.right != null) path.remove(path.size() - 1);
    }
}
