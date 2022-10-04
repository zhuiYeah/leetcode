package 二叉树;

public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //让右边最小的连上左边最大的
                var tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                //此时tmp就是右边最小的，root.left就是左边最大的
                tmp.left = root.left;
                return root.right;
            }
        }
    }
}
