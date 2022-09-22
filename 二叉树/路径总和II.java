package 二叉树;

//给出所有从跟节点到叶子节点和为targetsum的路径

import java.util.ArrayList;
import java.util.List;


//这里path不作为全局变量，而作为参数在backtracking中传递，回溯阶段居然也要处理path，这为什么？？？不理解
//curSum不作为全局变量，作为参数在backtracking中传递，回溯阶段不需要处理curSum，这是正常的
//猜测是由于List<> 结构的特殊性造成的

public class 路径总和II {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        backtracking(root, 0, new ArrayList<Integer>());
        return res;
    }

    public void backtracking(TreeNode root, int curSum, List<Integer> path) {
        if (root == null) return;
        //对当前节点的处理
        curSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {//叶子节点
            if (curSum == targetSum) {
                List<Integer> tmp = new ArrayList<>(path);
                res.add(tmp);
            }
            return;
        }
        backtracking(root.left, curSum, path);//回溯判断
        //回溯
        if (root.left != null) {
            path.remove(path.size() - 1);
        }
        backtracking(root.right, curSum, path);//回溯判断
        //回溯
        if (root.right != null) {
            path.remove(path.size() - 1);
        }
    }
}
