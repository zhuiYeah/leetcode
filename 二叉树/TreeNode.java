package 二叉树;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    } //构造函数1

    TreeNode(int val, TreeNode left, TreeNode right) { //构造函数2
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
