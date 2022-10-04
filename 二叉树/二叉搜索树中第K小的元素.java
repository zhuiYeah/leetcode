package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中第K小的元素 {
    int K;
    List<Integer> nums = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        help(root);
        return nums.get(nums.size() - 1);

    }

    public void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        //中序遍历到第k个结束
        if (nums.size() == K) {
            return;
        }
        nums.add(root.val);
        help(root.right);
    }
}

class ewfcwe {
    int num = 0;
    int res;
    int K;

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        num++;
        //目前所在的节点是第num个节点
        if (num == K) {
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
