package 周赛;

//哎 没写出来 差一点点
public class _二叉树灯饰 {
    public int closeLampInTree(TreeNode root) {
        return f(root)[0];
    }

    public int[] f(TreeNode node) { // {all 0, all 1, 0 + sub 1, 1 + sub 0}
        if (node == null) return new int[4];
        int[] l = f(node.left), r = f(node.right);
        int[] res = new int[4];
        res[0] = Math.min(node.val + l[0] + r[0],
                Math.min((1 - node.val) + l[1] + r[1] + 1,
                        Math.min(node.val + l[2] + r[2] + 2,
                                (1 - node.val) + l[3] + r[3] + 1)));

        res[1] = Math.min(Math.min((1 - node.val) + l[1] + r[1],
                        node.val + l[0] + r[0] + 1),
                Math.min(node.val + l[2] + r[2] + 1,
                        (1 - node.val) + l[3] + r[3] + 2));
        res[2] = Math.min(Math.min(2 - node.val + l[0] + r[0],
                        node.val + l[1] + r[1]),
                Math.min(2 - node.val + l[2] + r[2],
                        node.val + l[3] + r[3] + 2));
        res[3] = Math.min(Math.min(1 - node.val + l[0] + r[0],
                        node.val + 1 + l[1] + r[1]),
                Math.min(3 - node.val + l[2] + r[2],
                        node.val + 1 + l[3] + r[3]));
        return res;
    }
}
