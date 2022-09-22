package 二叉树;


import java.util.ArrayList;

//曾经空了很久没做的题目如今能够秒杀 太励志了
//最坏情况下需要 O(n* min(2^len+1,n)) len是链表的长度，n是二叉树的节点个数

public class 二叉树中的列表 {
    ArrayList<Integer> list = new ArrayList();
    int n;

    public boolean isSubPath(ListNode head, TreeNode root) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        n = list.size();
        return preorder(root);
    }

    public boolean preorder(TreeNode root) { //前序遍历每个节点，从该节点开始判断是否存在子路径，如果不存在的话再判断下一个节点
        if (root == null) return false;
        if (dfs(root, 0)) {
            return true;
        }
        if (preorder(root.left)) return true;
        if (preorder(root.right)) return true;
        return false;
    }

    public boolean dfs(TreeNode root, int curIndex) { //能否从root节点开始存在给定链表的子路径

        if (curIndex == n) return true;
        if (root == null) return false;
        if (root.val != list.get(curIndex)) return false;
        if (dfs(root.left, curIndex + 1)) return true;
        if (dfs(root.right, curIndex + 1)) return true;
        return false;
    }
}
