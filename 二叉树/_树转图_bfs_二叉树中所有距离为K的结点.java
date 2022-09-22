package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _树转图_bfs_二叉树中所有距离为K的结点 {
    Map<Integer, TreeNode> parent = new HashMap<>(); //记录每个节点的父节点
    //key:当前节点的值  value：指向父节点的引用
    List<Integer> res = new ArrayList<Integer>();
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        K = k;
        findParent(root);
        dfsK(target, null, 0);
        return res;
    }

    public void findParent(TreeNode root) {
        //if (root == null) return;
        if (root.left != null) {
            parent.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            findParent(root.right);
        }
    }

    //单一个元素from去重， 非常牛逼
    public void dfsK(TreeNode root, TreeNode from, int depth) { //记录当前节点root是从哪个节点过来的，避免往回搜索
        if (root == null) return;
        if (depth == K) {
            res.add(root.val);
            return;
        }
        if (root.left != from) {
            dfsK(root.left, root, depth + 1);
        }
        if (root.right != from) {
            dfsK(root.right, root, depth + 1);
        }
        if (parent.get(root.val) != from) {
            dfsK(parent.get(root.val), root, depth + 1);
        }
    }

}
