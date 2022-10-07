package 二叉树;

public class 从先序遍历还原二叉树 {
    String s;
    int n;
    //ptr时刻指向当前数字 ， preptr时刻指向前一个数字末尾的'-'
    //ptr - preptr 就是当前数字所应该在的深度
    int preptr;
    int ptr;

    public TreeNode recoverFromPreorder(String traversal) {
        preptr = 0;
        ptr = 0;
        s = traversal;
        n = s.length();
        var fakeHead = new TreeNode();
        //父亲节点告诉子节点，你的父亲是谁，你是否作为左子节点，你的当前深度应该是多少
        dfs(fakeHead, true, 0);
        return fakeHead.left;
    }

    public void dfs(TreeNode father, boolean isLeft, int curDepth) {
        int realDepth = ptr - preptr;
        if (realDepth != curDepth) return;
        var son = new TreeNode(getInteger());
        if (isLeft) {
            father.left = son;
        } else {
            father.right = son;
        }
        dfs(son, true, curDepth + 1);
        dfs(son, false, curDepth + 1);
    }

    public int getInteger() {
        int tail = ptr;
        for (; tail < n; tail++) {
            if (s.charAt(tail) == '-') break;
        }
        int tmp = ptr;
        preptr = tail;
        for (ptr = tail; ptr < n; ptr++) {
            if (s.charAt(ptr) != '-') break;
        }
        return Integer.parseInt(s.substring(tmp, tail));
    }
}

