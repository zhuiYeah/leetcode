package 链蒸蒸简单;

//二叉树只有三个节点 太简单了
public class 判断根结点是否等于子结点之和 {
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }
}
