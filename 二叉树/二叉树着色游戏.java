package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 二叉树着色游戏 {
    //    //当前节点的数值 -> 其父节点的映射
//    Map<Integer,TreeNode> father = new HashMap<Integer,TreeNode>();
    //本来想转成图进行三次搜索，发现没有必要
    TreeNode start;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        findX(root, x);
        double num = (double) n / 2.0;
        int left = n - nodeNum(start.left);
        int right = n - nodeNum(start.right);
        int father = n - left + n - right + 1;
        //我可以堵住你的左侧右侧上侧其中之一，只要三种堵法的其中之一奏效，我就能赢
        if (left < num || right < num || father < num) {
            return true;
        }
        return false;
    }

    public boolean findX(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) {
            start = root;
            return true;
        }
        if (findX(root.left, target)) {
            return true;
        }
        if (findX(root.right, target)) {
            return true;
        }
        return false;
    }

    public int nodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return nodeNum(node.left) + nodeNum(node.right) + 1;
    }
}
