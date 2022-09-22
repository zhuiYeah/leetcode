package 二叉树;

import java.util.HashMap;
import java.util.Map;

//完全错了，思路错了
public class dfs感染二叉树需要的总时间 {
    public int amountOfTime(TreeNode root, int start) {
        TreeNode ganRanRoot = find(root, start);
//        boolean left = contains(root.left, ganRanRoot);
//        boolean right = contains(root.right, ganRanRoot);
        int time1 = depth(ganRanRoot) - 1;
        return Math.max(depth(root.left) + depth(root.right) - time1, time1);
    }

    public TreeNode find(TreeNode root, int target) { //找到最开始的感染源节点
        if (root == null) return null;
        if (root.val == target) return root;
        TreeNode left = find(root.left, target);
        if (left != null) return left;
        TreeNode right = find(root.right, target);
        if (right != null) return right;
        return null;
    }

//    public boolean contains(TreeNode root, TreeNode target) {//看看root树中是否包含目标节点target
//        if (root == null) return false;
//        if (root.val == target.val) return true;
//        if (contains(root.left, target)) {
//            return true;
//        }
//        if (contains(root.right, target)) {
//            return true;
//        }
//        return false;
//    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class CXececed {
    HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();//映射值为key节点的父亲节点
    int time = 0;

    public int amountOfTime(TreeNode root, int start) {
        findFather(root, null);
        TreeNode SourceOfInfection = find(root, start);
        dfs(SourceOfInfection, 0, null);
        return time;
    }

    public void findFather(TreeNode root, TreeNode father) { //建立子节点到父节点的映射表
        if (root == null) return;
        map.put(root.val, father);
        findFather(root.left, root);
        findFather(root.right, root);
    }

    public TreeNode find(TreeNode root, int target) { //找到最开始的感染源节点
        if (root == null) return null;
        if (root.val == target) return root;
        TreeNode left = find(root.left, target);
        if (left != null) return left;
        TreeNode right = find(root.right, target);
        if (right != null) return right;
        return null;
    }

    public void dfs(TreeNode root, int curTime, TreeNode from) {//记录当前节点来自哪个节点，避免往回搜索
        if (root == null) return;
        time = Math.max(time, curTime);
        if (map.get(root.val) != from) {
            dfs(map.get(root.val), curTime + 1, root);
        }
        if (root.left != from) {
            dfs(root.left, curTime + 1, root);
        }
        if (root.right != from) {
            dfs(root.right, curTime + 1, root);
        }
    }
}
