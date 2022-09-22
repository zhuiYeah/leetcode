package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 将二叉搜索树变平衡 {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return returnBST(0, list.size() - 1);
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public TreeNode returnBST(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = returnBST(start, mid - 1);
        node.right = returnBST(mid + 1, end);
        return node;
    }
}
