package 二叉树;


import java.util.ArrayList;
import java.util.List;

public class __所有可能的真二叉树 {


    public static List<TreeNode> allPossibleFBT(int N) { //返回节点数为N的所有可能满二叉树
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i); //获得左边的节点数为i的所有可能二叉树结果
            List<TreeNode> right = allPossibleFBT(N - i - 1); //获得右边的节点数为N-1-i的所有可能的真二叉树的结果
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
