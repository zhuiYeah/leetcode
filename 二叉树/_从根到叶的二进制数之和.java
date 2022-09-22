package 二叉树;

import java.util.Arrays;

//本解法既包含了前序遍历、又包含了后序遍历、非常牛逼的解
public class _从根到叶的二进制数之和 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 2 + root.val; //前序的逻辑
        if (root.left == null && root.right == null) {//叶子节点了
            return sum;
        }
        //现在必然不是叶子结点，就是个中间节点，不会产生最终的sum，得到左叶子节点返回的sum和右叶子返回的sum
        int left = dfs(root.left, sum);
        int right = dfs(root.right, sum);
        return left + right; //后续的逻辑
    }
}


