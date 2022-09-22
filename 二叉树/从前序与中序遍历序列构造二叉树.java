package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        int rootVal = preorder[preorder_left];
        var root = new TreeNode(rootVal);
        int inorder_root = map.get(rootVal);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = dfs(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = dfs(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
