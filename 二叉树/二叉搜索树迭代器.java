package 二叉树;

import java.util.ArrayList;

public class 二叉搜索树迭代器 {
}

//剑指offer
class BSTIterator {
    ArrayList<Integer> list;
    int ptr = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE);
        dfs(root);
    }

    public int next() {
        ptr++;
        return list.get(ptr);
    }

    public boolean hasNext() {
        if (ptr+1 <= list.size()-1)  return true;
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}