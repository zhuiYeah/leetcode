package 链表;

//判断一个链表是不是回文链表
public class 回文链表_递归 {
    ListNode root;

    public boolean isPalindrome(ListNode head) {
        root = head;
        return dfs(head);
    }

    public boolean dfs(ListNode head) {
        if (head == null) return true;
        //链表的后序遍历哈哈哈
        if (!dfs(head.next)) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        //回溯阶段
        root = root.next;
        return true;
    }
}
