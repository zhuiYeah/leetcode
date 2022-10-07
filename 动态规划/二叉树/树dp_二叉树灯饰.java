package 动态规划.二叉树;


//秋季编程大赛

//二叉树的灯泡（0表示关闭 ， 1表示打开），对于每个点 ：三种操作，全变化，变化当前点，变化左右子节点以及当前点，
//那么最少需要多少次操作可以让灯泡全关（0）



//哎 没写出来 差一点点
//思路完全是对的，只是没有成功确认dp数组的含义以及状态转移方程
//二叉树上的动态规划
public class 树dp_二叉树灯饰 {
    public int closeLampInTree(TreeNode root) {
        return f(root)[0];
    }

    public int[] f(TreeNode node) { // {all 0, all 1, 0 + sub 1, 1 + sub 0}
        if (node == null) return new int[4];
        int[] l = f(node.left), r = f(node.right);
        int[] res = new int[4];
        res[0] = Math.min(node.val + l[0] + r[0],
                Math.min((1 - node.val) + l[1] + r[1] + 1,
                        Math.min(node.val + l[2] + r[2] + 2,
                                (1 - node.val) + l[3] + r[3] + 1)));

        res[1] = Math.min(Math.min((1 - node.val) + l[1] + r[1],
                        node.val + l[0] + r[0] + 1),
                Math.min(node.val + l[2] + r[2] + 1,
                        (1 - node.val) + l[3] + r[3] + 2));
        res[2] = Math.min(Math.min(2 - node.val + l[0] + r[0],
                        node.val + l[1] + r[1]),
                Math.min(2 - node.val + l[2] + r[2],
                        node.val + l[3] + r[3] + 2));
        res[3] = Math.min(Math.min(1 - node.val + l[0] + r[0],
                        node.val + 1 + l[1] + r[1]),
                Math.min(3 - node.val + l[2] + r[2],
                        node.val + 1 + l[3] + r[3]));
        return res;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class dwdew {
    public int closeLampInTree(TreeNode root) {
        return f(root)[0];
    }

    public int[] f(TreeNode root) { // {all 0, all 1, 0 + sub 1, 1 + sub 0}
        //dp[0] : 让本颗数全0所需要的最小操作数
        if (root == null) return new int[4];
        var left = f(root.left);
        var right = f(root.right);
        var dp = new int[4];
        dp[0] = min4(left[0] + right[0] + root.val, left[1] + right[1] + 2 - root.val,
                left[2] + right[2] + 2 + root.val, left[3] + right[3] + 2 - root.val);
        dp[1] = min4(left[0] + right[0] + root.val + 1, left[1] + right[1] + 1 - root.val,
                left[2] + right[2] + 1 + root.val, left[3] + right[3] + 3 - root.val);
        dp[2] = min4(left[0] + right[0] + 2 - root.val, left[1] + right[1] + root.val,
                left[2] + right[2] + 2 - root.val, left[3] + right[3] + 2 + root.val);
        dp[3] = min4(left[0] + right[0] + 1 - root.val, left[1] + right[1] + 1 + root.val,
                left[2] + right[2] + 3 - root.val, left[3] + right[3] + 1 + root.val);
        return dp;
    }

    public int min4(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
