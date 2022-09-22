package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dfs出现次数最多的子树元素和 {
    Map<Integer, Integer> fre = new HashMap<>();
    int maxFre = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        var res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
            if (entry.getValue() == maxFre) {
                res.add(entry.getKey());
            }
        }
//        Integer[] result = new Integer[res.size()];
//        res.toArray(result);
        //这种奇淫巧计反而很慢
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        var sum = left + root.val + right;
        fre.put(sum, fre.getOrDefault(sum, 0) + 1);
        if (fre.get(sum) > maxFre) {
            maxFre = fre.get(sum);
        }
        return sum;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//朴素 List 转 int[]
class dededwe {
    Map<Integer, Integer> fre = new HashMap<>();
    int maxFre = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        var res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
            if (entry.getValue() == maxFre) {
                res.add(entry.getKey());
            }
        }
        var result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        var sum = left + root.val + right;
        fre.put(sum, fre.getOrDefault(sum, 0) + 1);
        if (fre.get(sum) > maxFre) {
            maxFre = fre.get(sum);
        }
        return sum;
    }
}
