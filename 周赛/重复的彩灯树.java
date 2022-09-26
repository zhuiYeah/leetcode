package 周赛;

import java.util.*;

public class 重复的彩灯树 {
    List<TreeNode> res = new ArrayList<>();
    //存放出现的所有树的string
    Set<String> tree = new HashSet<>();
    HashMap<String, TreeNode> map = new HashMap<>();

    public List<TreeNode> lightDistribution(TreeNode root) {
        dfs(root);
        for (Map.Entry<String, TreeNode> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "*";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        String x = root.val + "-" + left + "-" + right;
        if (tree.contains(x)) {
            map.put(x, root);
        } else {
            tree.add(x);
        }
        return x;
    }
}
