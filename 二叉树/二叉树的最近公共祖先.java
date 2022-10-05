package 二叉树;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //如果本节点为p或者为q，那么它就是 p的祖先｜｜q的祖先｜｜p，q的公共祖先，他的子树中一定不存在p q的公共祖先，可以中止往下的递归了
        if (root == p || root == q) return root;
        var left = lowestCommonAncestor(root.left,p,q);
        var right = lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) {
            return root;
        }else if (left == null) {
            return right;
        }else {
            return left;
        }
    }
}
