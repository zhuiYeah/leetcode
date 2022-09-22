package 二叉树;

public class 从叶结点开始的最小字符串 {
    StringBuffer path = new StringBuffer();
    String res = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

    public String smallestFromLeaf(TreeNode root) {
        backtracking(root);
        return res;
    }

    public void backtracking(TreeNode root) {
        //if (root == null) return;
        path.insert(0, (char) (root.val + (byte) 'a'));
        if (root.left == null && root.right == null) { //叶子结点
            if (compare(res, path.toString())) {
                res = path.toString();
            }
            return;
        }
        if (root.left != null) {
            backtracking(root.left);
            path.delete(0, 1);
        }
        if (root.right != null) {
            backtracking(root.right);
            path.delete(0, 1);
        }
    }

    public boolean compare(String s1, String s2) {
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < s1.length() && ptr2 < s2.length()) {
            if (s1.charAt(ptr1) < s2.charAt(ptr2)) {
                return false;
            } else if (s1.charAt(ptr1) > s2.charAt(ptr2)) {
                return true;
            }
            ptr1++;
            ptr2++;
        }
        if (s1.length() <= s2.length()) {
            return false;
        } else {
            return true;
        }
    }
}

////////////////////////////////////////////////////////////////////////
//将path作为局部变量在回溯中传递会怎么样 ?
//也需要path.delete(0,1)的回溯处理
//是因为path是全局共享的变量？还是说是本题回溯的逻辑特殊使得它需要回溯处理？
class dewde {
    //StringBuffer path = new StringBuffer();
    String res = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

    public String smallestFromLeaf(TreeNode root) {
        backtracking(root, new StringBuilder());
        return res;
    }

    public void backtracking(TreeNode root, StringBuilder path) {
        //if (root == null) return;
        path.insert(0, (char) (root.val + (byte) 'a'));

        if (root.left == null && root.right == null) { //叶子结点
            if (compare(res, path.toString())) {
                res = path.toString();
            }
            return;
        }
        if (root.left != null) {
            backtracking(root.left, path);
            path.delete(0, 1);
        }
        if (root.right != null) {
            backtracking(root.right, path);
            path.delete(0, 1);
        }
    }

    public boolean compare(String s1, String s2) {
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < s1.length() && ptr2 < s2.length()) {
            if (s1.charAt(ptr1) < s2.charAt(ptr2)) {
                return false;
            } else if (s1.charAt(ptr1) > s2.charAt(ptr2)) {
                return true;
            }
            ptr1++;
            ptr2++;
        }
        if (s1.length() <= s2.length()) {
            return false;
        } else {
            return true;
        }
    }
}
