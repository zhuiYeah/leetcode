package 二叉树;

public class dfs层数最深叶子节点之和 {
    int res = 0;
    int maxDepth = -1;

    public int deepestLeavesSum(TreeNode root) {
        dfs(0, root);
        return res;
    }

    public void dfs(int curLayer, TreeNode node) {
        if (node == null) {
            return;
        }
        if (curLayer >maxDepth){
            maxDepth = curLayer;
            res = node.val;
        }else if (curLayer==maxDepth){
            res += node.val;
        }
        dfs(curLayer + 1, node.left);
        dfs(curLayer + 1, node.right);
    }
}





