package 二叉树;

//如果一个节点的左右子树的深度相同，那么这个节点就是最深叶结点的最近公共祖先
public class 最深叶结点的最近公共祖先 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution2 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}