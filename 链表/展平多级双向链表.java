package 链表;


//剑指offer
public class 展平多级双向链表 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int v) {
            val = v;
        }
    }

    private Node tmp;

    public Node flatten(Node head) {
        Node fakeHead = new Node(1);
        tmp = fakeHead;
        dfs(head);
        if (head != null) fakeHead.next.prev = null;
        return fakeHead.next;
    }

    public void dfs(Node head) {
        //if (head == null) return;
        while (head != null) {
            tmp.next = new Node(head.val);
            tmp.next.prev = tmp;
            tmp = tmp.next;
            if (head.child != null) {
                dfs(head.child);
            }
            head = head.next;
        }
    }
}
