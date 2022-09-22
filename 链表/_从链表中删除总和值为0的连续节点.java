package 链表;

//时间复杂度O(n^2) , n为链表的节点个数
public class _从链表中删除总和值为0的连续节点 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        //以head作为开头，是否存在一段以head开头的和为0的连续节点，如果存在的话，删去这段节点
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            if (sum == 0) { //说明当前从head到tmp的节点之和为0 ，这段节点都需要移除
                return removeZeroSumSublists(tmp.next);
            }
        }
        //能到达这里说明不存在从head开始的一段和为0的连续节点，那么从head next开始
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
