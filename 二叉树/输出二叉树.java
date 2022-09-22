package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 输出二叉树 {
    static int height;
    List<List<String>> res = new ArrayList<>();


    public List<List<String>> printTree(TreeNode root) {

        height = depth(root) - 1;
        int m = height + 1;
        int n = (int) Math.pow(2, height + 1) - 1;
        //List你只能一个一个加元素了
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(root, 0, (n - 1) / 2);
        return res;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public void dfs(TreeNode root, int i, int j) {
        if (root == null) return;
        //list修改元素用set
        res.get(i).set(j, Integer.toString(root.val));
        int element = (int) Math.pow(2, height - i - 1);
        dfs(root.left, i + 1, j - element);
        dfs(root.right, i + 1, j + element);
    }
}

