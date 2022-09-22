package 递归;


import java.util.ArrayList;
import java.util.List;

public class __所有可能的真二叉树 {
    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
