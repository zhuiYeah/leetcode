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


//剑指offer
class dwdw {
    private ListNode head;

    public boolean isPalindrome(ListNode head) {
        this.head = head;
        return dfs(head);
    }

    private boolean dfs(ListNode cur) {
        if (cur == null) return true;
        if (!dfs(cur.next)) return false;
        //if (cur == head || head.next == cur) return cur.val == head.val;
        if (cur.val != head.val) return false;
        head = head.next;
        return true;
    }
}
