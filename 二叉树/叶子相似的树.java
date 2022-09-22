package 二叉树;

import java.util.ArrayList;

public class 叶子相似的树 {
    ArrayList<Integer> tmp = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        ArrayList<Integer> x1 = new ArrayList<>(tmp);
        tmp.clear();
        dfs(root2);
        ArrayList<Integer> x2 = new ArrayList<>(tmp);
        return x1.equals(x2); //arraylist比较相同
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
