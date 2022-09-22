package 哈希表;


import java.util.TreeSet;

//有序集合，可以按照给定范围搜索集合的元素
public class TreeSet_二叉搜索树染色 {
    TreeSet<Integer> set = new TreeSet<>();

    public int getNumber(TreeNode root, int[][] ops) {
        inorder(root);
        int n = ops.length;
        int oneCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int start = ops[i][1];
            int end = ops[i][2];
            while (true) {
                Integer upper = set.higher(start - 1);
                if (upper == null || upper > end) break;
                set.remove(upper);
                if (ops[i][0] == 1) oneCount++;
            }
        }
        return oneCount;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}
