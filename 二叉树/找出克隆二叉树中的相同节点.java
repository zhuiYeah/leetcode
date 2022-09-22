package 二叉树;


import java.util.*;


//二叉树节点的值各不相同的情况 ，可以根据值来确定节点
public class 找出克隆二叉树中的相同节点 {
    TreeNode res;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        help(cloned, target.val);
        return res;
    }

    public boolean help(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            res = root;
            return true;
        }
        if (help(root.left, val)) {
            return true;
        }
        if (help(root.right, val)) {
            return true;
        }
        return false;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//如果二叉树里面有相同的值，那么只能根据内存地址来查找了
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution3 {
    TreeNode res;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        help(original, cloned, target);
        return res;
    }

    public boolean help(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return false;
        }
        if (original == target) {
            res = cloned;
            return true;
        }
        if (help(original.left, cloned.left, target)) {
            return true;
        }
        if (help(original.right, cloned.right, target)) {
            return true;
        }
        return false;
    }
}

