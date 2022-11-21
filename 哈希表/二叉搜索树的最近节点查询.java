package 哈希表;


import java.util.*;

public class 二叉搜索树的最近节点查询 {
    TreeSet<Integer> set = new TreeSet<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x : queries) {
            Integer down = set.floor(x);
            Integer up = set.ceiling(x);
            var list = new ArrayList<Integer>();
            if (down != null) list.add(down);
            else list.add(-1);
            if (up != null) list.add(up);
            else list.add(-1);
            res.add(list);
        }
        return res;

    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        set.add(root.val);
        dfs(root.right);
    }
}