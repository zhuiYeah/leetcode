package 二叉树;

import java.util.HashMap;
import java.util.Map;

//287 / 332 个通过测试用例
//超出内存限制
public class dfs_从二叉树的一个节点到另一个节点每一步的方向 {
    Map<Integer, TreeNode> father = new HashMap<>();//一个节点到他的父节点之间的映射
    String res;
    TreeNode start;
    int startValue;
    int endValue;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        //构造所有节点到他的父节点之间的映射,并找到开始节点
        this.endValue = destValue;
        this.startValue = startValue;
        constructFather(root, null);
        //开始深搜目标节点了
        dfs(start, null, "");
        return res;
    }

    public void constructFather(TreeNode root, TreeNode from) {
        if (root == null) return;
        if (root.val == startValue) {
            start = root;
        }
        father.put(root.val, from);
        constructFather(root.left, root);
        constructFather(root.right, root);
    }

    public boolean dfs(TreeNode root, TreeNode from, String path) {
        if (root == null) return false;
        if (root.val == endValue) {
            res = path;
            return true;
        }
        if (father.get(root.val) != from) {
            if (dfs(father.get(root.val), root, path + "U")) {
                return true;
            }
        }
        if (root.left != from) {
            if (dfs(root.left, root, path + "L")) {
                return true;
            }
        }
        if (root.right != from) {
            if (dfs(root.right, root, path + "R")) {
                return true;
            }
        }
        return false;
    }
}


