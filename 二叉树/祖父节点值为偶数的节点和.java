package 二叉树;

//对于每个节点，判定传给下一个节点的father和grandfather
public class 祖父节点值为偶数的节点和 {
    int res;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);
        return res;
    }

    public void dfs(TreeNode root, boolean father, boolean grandfather) {
        if (root == null) return;
        //对当前节点是否满足条件进行判断
        if (grandfather) res += root.val;
        //对下一个节点的父亲节点（即自己） 和 下一个节点的祖父节点（即自己的父节点） 是否为偶数进行处理
        grandfather = father;
        father = root.val % 2 == 0;
        dfs(root.left, father, grandfather);
        dfs(root.right, father, grandfather);
    }
}
