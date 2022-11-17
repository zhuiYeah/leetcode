package _周赛;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//来自319场周赛，难点在于 使一个数组有序的最小交换次数
public class 逐层排序二叉树所需的最少操作数目 {
    public int minimumOperations(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            var list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            count += count(list);
        }
        return count;
    }

    //排序一个数组需要的最小交换次数 （循环节）
    private int count(ArrayList<Integer> list) {
        int n = list.size();
        var nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = list.get(i);
        Arrays.sort(nums);
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) map.put(nums[i], i);//记录排序后数值应在的正确位置
        int lops = 0;//循环节个数
        var flag = new boolean[n];//该位置的数是否被访问过

        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                int j = i;
                while (!flag[j]) {
                    flag[j] = true;
                    //j变成当前值应在的正确位置
                    j = map.get(list.get(j));
                }
                lops += 1;
            }
        }
        return n - lops;
    }

}
