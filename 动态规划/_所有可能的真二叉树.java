package 动态规划;


import java.util.ArrayList;
import java.util.List;


public class _所有可能的真二叉树 {
//    static List<TreeNode> res = new ArrayList<>();
//    static TreeNode root = new TreeNode(0); //永远的根节点
//    static int n;
//
//    public static List<TreeNode> allPossibleFBT(int x) {
//
//        n = x;
//        if (n % 2 == 0) return res;
//        if (n == 1) {
//            res.add(new TreeNode(0));
//            return res;
//        }
//        dfs(root, 1, 1);
//        return res;
//    }
//
//    public static void dfs(TreeNode node, int curPos, int FenPeiEd) {
//        if (curPos == n - 1) { //收集到了一颗真二叉树了
//            res.add(clone(root));
//            return;
//        }
//        if (curPos == n) return;
//
//        node.left = new TreeNode(0);
//        node.right = new TreeNode(0);
//
//        dfs(node.left, FenPeiEd + 1, FenPeiEd + 2);
//        dfs(node.right, FenPeiEd + 2, FenPeiEd + 2);
//
//        node.left = null;
//        node.right = null;
//
//    }
//
//    public static TreeNode clone(TreeNode root) { //克隆一颗二叉树root
//        if (root == null) return null;
//        TreeNode node = new TreeNode(root.val);
//        node.left = clone(root.left);
//        node.right = clone(root.right);
//        return node;
//    }
//
//    public static void main(String[] args) {
//        allPossibleFBT(7);
//    }
}

//太难了
//时间复杂度 O(2^n)
class Solution2 {


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


//    public static TreeNode clone(TreeNode root) { //克隆一颗二叉树root
//        if (root == null) return null;
//        TreeNode node = new TreeNode(root.val);
//        node.left = clone(root.left);
//        node.right = clone(root.right);
//        return node;
//    }
}