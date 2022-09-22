package 二叉树;

//过程中处理，同时向上层返回的又一好题目
//兄弟题目：二叉树染色

//两个叶子节点的距离小于distance，则认为是一个好叶子节点对
public class _好叶子节点对的数量 {
    //利用count数组记录，count[i] : 与该节点距离为i的叶子节点的数目为count[i];
    int res;
    int distance;

    public int countPairs(TreeNode root, int distance) {
        if (distance == 1) {
            return 0;
        }
        this.distance = distance;
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[distance];
        //count[i] : 距离为i的叶子节点的个数为count[i]
        int[] count = new int[distance]; //count是返回给他的父节点的
        if (root.left == null && root.right == null) {
            count[1] = 1;
            return count;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //过程中处理
        for (int i = 1; i <= distance - 1; i++) {
            for (int j = 1; j <= distance - i; j++) {
                res += left[i] * right[j];
            }
        }
        //构造往父节点返回的数组
        for (int i = 1; i < distance; i++) {
            count[i] = left[i - 1] + right[i - 1];
        }
        return count;
    }
}
