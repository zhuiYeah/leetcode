package 动态规划.二叉树;


import java.util.Arrays;

//打家劫舍终极版 ， 在树上进行自底向上的动态规划
//兄弟题目：好叶子节点对的数量，都构造了一个数组向上返回

public class 树dp__二叉树染色 {
    int K;

    public int maxValue(TreeNode root, int k) {
        K = k;
        var dp = dfs(root);
        return Arrays.stream(dp).max().getAsInt();
    }

    public int[] dfs(TreeNode root) {
        //dp[i] : 当前节点，以及当前节点的子节点，连续染色i个，能获得的最大收益为dp[i]
        var dp = new int[K + 1];
        if (root == null) {
            return dp;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        dp[0] = Arrays.stream(left).max().getAsInt() + Arrays.stream(right).max().getAsInt();
        //dp[1] = root.val + left[0] + right[0];
        for (int i = 1; i <= K; i++) {
            //需要连续染色i个节点（当然包含了当前节点）
            for (int j = 0; j <= i - 1; j++) {
                //左边节点连续染色j个，右边节点连续染色i-j-1个
                dp[i] = Math.max(dp[i], left[j] + right[i - j - 1] + root.val);
            }
        }
        return dp;
    }


}
