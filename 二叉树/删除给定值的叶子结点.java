package 二叉树;

//后序遍历即可，不需要前序遍历
public class 删除给定值的叶子结点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        //if (root.left == null && root.right == null && root.val == target) return null; //前序
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) return null; //后序
        return root;
    }
}
