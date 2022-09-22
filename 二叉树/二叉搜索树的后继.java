package 二叉树;

import java.util.*;

//暴力遍历时间复杂度O（n） 4ms
public class 二叉搜索树的后继 {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == p) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////
//利用二叉搜索树的特性 2ms
class sws {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) { //后继一定在root的右子树上
            return inorderSuccessor(root.right, p);
        }
        //否则后继可能就是root，或者在左子树上
        TreeNode node = inorderSuccessor(root.left, p);
        if (node == null) {
            return root;
        } else {
            return node;
        }
    }
}
