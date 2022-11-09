package 二叉树;

//剑指offer
public class _二叉搜索树中的中序后继 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                //root可能是p的中序后继,root左边的值也有可能是p的中序后继
                res = root;
                root = root.left;
            } else if (root.val < p.val) {
                //root不可能是p的中序后继，root右边的值可能是p的中序后继
                root = root.right;
            } else {
                //p就是root，找到p右子树中最小的值
                if (root.right == null) {
                    break;
                } else {
                    root = root.right;
                    while (root != null) {
                        res = root;
                        root = root.left;
                    }
                }
            }
        }
        return res;
    }
}
