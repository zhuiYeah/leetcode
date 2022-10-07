package 蒸蒸简单;

//只知道当前的节点，不知道当前节点的前一个节点，如何删除当前节点
public class 删除中间节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
