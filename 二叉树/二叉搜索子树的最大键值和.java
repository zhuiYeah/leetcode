package 二叉树;

//二叉树中的二叉搜索树，难点在于判断一颗普通二叉树中的二叉搜索树　　　　　　　　　　　
//给一颗二叉树 ， 找到其中的子树为二叉搜索树的子树，并给出其中的和最大的二叉搜索树的和。
public class 二叉搜索子树的最大键值和 {
    int max = 0;

    static class Status {
        //记录以当前节点为根节点的节点是否为二叉搜索树
        boolean isValidBST;
        //只有isValidBST是true时，下面的数据才有意义，下面的数据是传递给上层使用的
        int sum;
        int min;
        int max;

        public Status(boolean isValidBST, int sum, int min, int max) {
            this.isValidBST = isValidBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }

    public Status dfs(TreeNode root) {
        if (root == null) return new Status(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return new Status(true, root.val, root.val, root.val);
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        //只有当左子树为BST，右子树为BST ， root的值大于左子树的所有值（最大值），小于右子树的最小值，那么当前树才能构成二叉搜索树
        if (left.isValidBST && right.isValidBST && root.val > left.max && root.val < right.min) {
            max = Math.max(max, root.val + left.sum + right.sum);
            return new Status(true, root.val + left.sum + right.sum,
                    Math.min(root.val, Math.min(left.min, right.min)),
                    Math.max(root.val, Math.max(right.max, left.max)));
        }
        return new Status(false, 0, 0, 0);
    }

}

