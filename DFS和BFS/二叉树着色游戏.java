package DFS和BFS;

/**
 * 玩一个游戏，一号玩家先手，他在二叉树的任意一个点标记为红色，二号玩家后手，他在二叉树的任意其他位置标记为蓝色
 * 接下来的回合，只能从自己的已染色的节点的两个子节点或者父亲节点进行染色，
 * 你扮演二号玩家，如果存在赢的可能性，返回true，如果不存在赢的可能性，返回false
 */

//贪心 + dfs
public class 二叉树着色游戏 {
    TreeNode start;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int leftNum = countNodeNum(start.left);
        int rightNum = countNodeNum(start.right);
        int fatherNum = n - leftNum - rightNum - 1;
        return leftNum > n / 2 || rightNum > n / 2 || fatherNum > n / 2;
    }

    //本dfs会找到x所在的节点
    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        if (root.val == target) {
            start = root;
            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }

    //计算以root作为跟节点的二叉树节点总数
    private int countNodeNum(TreeNode root) {
        if (root == null) return 0;
        return countNodeNum(root.left) + countNodeNum(root.right) + 1;
    }
}
