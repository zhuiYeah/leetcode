package 二叉树;

//其实有回溯的思想在里面
public class 二叉树中的伪回文路径 {
    int[] fre = new int[10];
    int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        fre[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPal()) {
                count++;
                //删掉下面两行依然是正确的
                fre[root.val]--;
                return;
            }
        }
        dfs(root.left);
        dfs(root.right);
        fre[root.val]--;
    }

    public boolean isPal() {
        int x = 0;
        for (int i = 1; i <= 9; i++) {
            if (fre[i] % 2 != 0) {
                x++;
            }
            if (x >= 2) {
                return false;
            }
        }
        return true;
    }

}
