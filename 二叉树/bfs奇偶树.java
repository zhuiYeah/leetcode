package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class bfs奇偶树 {

    public boolean isEvenOddTree(TreeNode root) {
        int level = -1;
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int n = queue.size();
            var curLevelArr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                assert cur != null;
                curLevelArr.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (!isValid(level, curLevelArr)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int level, ArrayList<Integer> arr) {
        if (level % 2 == 0) {
            //必须是递增的奇数
            if (arr.get(0) % 2 == 0) return false;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 0) return false;
                if (arr.get(i) - arr.get(i - 1) <= 0) return false;
            }
        } else {
            //必须是递减的偶数
            if (arr.get(0) % 2 == 1) return false;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 1) return false;
                if (arr.get(i) - arr.get(i - 1) >= 0) return false;
            }
        }
        return true;
    }
}
