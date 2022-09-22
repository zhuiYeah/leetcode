package 二叉树;

import java.util.HashMap;
import java.util.Map;

//设置成static 只能通过一个测试用例
//删掉static通过了
//猜测是static会存在一些缓存问题
public class 统计最高分的节点数目 {
    //节点的值  -》 节点  ，存放所有可能的父节点
    Map<Integer, TreeNode> father = new HashMap<Integer, TreeNode>();
    int N;
    long max;
    int theFreOfMax;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        N = n;
        for (int i = 1; i < n; i++) {
            var up = father.getOrDefault(parents[i], new TreeNode(parents[i]));
            //当前的子节点有可能是之前的某个父节点，先从hashmap中获取
            var son = father.get(i);
            if (son == null) {
                son = new TreeNode(i);
            }
            if (up.left == null) {
                up.left = son;
            } else {
                up.right = son;
            }
            father.put(parents[i], up);
            father.put(i, son);
        }
        //树构建完成
        var root = father.get(0);
        dfs(root);
        return theFreOfMax;
    }

    //在dfs的过程中自底向上的统计每个节点的得分，并维护一个最大得分
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int up = N - left - right - 1;
        long score = 1;
        if (left != 0) score *= left;
        if (right != 0) score *= right;
        if (up != 0) score *= up;
        if (score > max) {
            max = score;
            theFreOfMax = 1;
        } else if (score == max) {
            theFreOfMax++;
        }
        return left + right + 1;
    }

    public static void main(String[] args) {
        //countHighestScoreNodes(new int[]{-1, 2, 0});

    }
}
