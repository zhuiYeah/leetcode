package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//写的还是复杂了一点
public class bfs二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int length = 1;//记录完全二叉树每层必须的长度
        boolean lastLay = false;
        ArrayList<Integer> children = new ArrayList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            if (n != length) { //本层必须是最后一层
                lastLay = true;
                if (!isCompleteTreeList(children)) {//由上一层的遍历记录下来本层的序列
                    return false;
                }
            }
            children.clear();
            length *= 2;

            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();

                if (cur.left != null) {
                    queue.add(cur.left);
                    children.add(1);
                } else {
                    children.add(0);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    children.add(1);
                } else {
                    children.add(0);
                }
            }
            if (lastLay && !queue.isEmpty()) {//如果当前已经是最后一层了，并且最后一层是满足完全二叉树的条件了，但发现居然不是最后一层
                return false;
            }
        }
        return true;
    }

    public boolean isCompleteTreeList(ArrayList<Integer> list) { //判断最后一层的二叉序列是否满足条件
        int n = list.size();
        boolean appearZero = false;
        for (int i = 0; i < n; i++) {
            if (!appearZero && list.get(i) == 0) {
                appearZero = true;
            }
            if (appearZero && list.get(i) == 1) {
                return false;
            }
        }
        return true;
    }
}


////////////////////////////////////
//stop标记为真之后（出现空节点之后），就不能再出现非空节点了
class edfced {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean stop = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                stop = true;
            } else {
                if (stop) return false;
                queue.add(cur.left);
            }
            if (cur.right == null) {
                stop = true;
            } else {
                if (stop) return false;
                queue.add(cur.right);
            }
        }
        return true;
    }
}
