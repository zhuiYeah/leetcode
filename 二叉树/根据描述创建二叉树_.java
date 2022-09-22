package 二叉树;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//写的太麻烦
public class 根据描述创建二叉树_ {
    //太麻烦了
//    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
//    //key : 父节点  value:左右子节点
//    Map<Integer, TreeNode> map2 = new HashMap<Integer, TreeNode>();
//
//    public TreeNode createBinaryTree(int[][] descriptions) {
//        for (int i = 0; i < descriptions.length; i++) {
//            int[] value = map.getOrDefault(descriptions[i][0], new int[]{0, 0});
//            if (descriptions[i][2] == 1) {
//                value[0] = descriptions[i][1];
//            } else {
//                value[1] = descriptions[i][1];
//            }
//            map.put(descriptions[i][0], value);
//        }
//        int rootVal = descriptions[0][0]; //假定一个根节点
//        TreeNode root = null;
//        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
//            TreeNode node = null;
//            if (map2.containsKey(e.getKey())) {
//                node = map2.get(e.getKey());
//                node.left =
//            }
//            if (e.getValue()[0] != 0) {
//                node.left = new TreeNode(e.getValue()[0]);
//            }
//            if (e.getValue()[1] != 0) {
//                node.right = new TreeNode(e.getValue()[1]);
//            }
//
//            if (e.getValue()[0] == rootVal) {
//                root = node;
//                rootVal = e.getKey();
//            }
//            if (e.getValue()[1] == rootVal) {
//                root = node;
//                rootVal = e.getKey();
//            }
//        }
//        return root;
//    }
    Map<Integer, TreeNode[]> map = new HashMap<Integer, TreeNode[]>();

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<Integer>(); //储存所有可能的根节点
        for (int i = 0; i < descriptions.length; i++) {
            set.add(descriptions[i][0]);
            TreeNode[] value = map.getOrDefault(descriptions[i][0], new TreeNode[]{null, null});
            if (descriptions[i][2] == 1) {
                value[0] = new TreeNode(descriptions[i][1]);
            } else {
                value[1] = new TreeNode(descriptions[i][1]);
            }
            map.put(descriptions[i][0], value);
        }

        for (Map.Entry<Integer, TreeNode[]> e : map.entrySet()) {
            TreeNode x = e.getValue()[0];
            TreeNode y = e.getValue()[1];
            if (x != null && set.contains(x.val)) {
                set.remove(x.val);
            }
            if (y != null && set.contains(y.val)) {
                set.remove(y.val);
            }
        }
        TreeNode root = null;
        for (int s : set) {
            root = new TreeNode(s);
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        TreeNode[] values = map.getOrDefault(root.val, new TreeNode[]{null, null});
        TreeNode left = values[0];
        TreeNode right = values[1];

        root.left = left;
        root.right = right;
        dfs(root.left);
        dfs(root.right);
    }
}
