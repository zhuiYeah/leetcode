package 链表;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class 复制带随机指针的链表 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //映射旧节点和新节点
        var map = new HashMap<Node, Node>();
        var fakeHead = new Node(0);
        var tmp = fakeHead;
        for (var i = head; i != null; i = i.next) {
            tmp.next = new Node(i.val);
            tmp = tmp.next;
            map.put(i, tmp);
        }
        tmp = fakeHead.next;
        for (var i = head; i != null; i = i.next, tmp = tmp.next) {
            tmp.random = map.get(i.random);
        }
        return fakeHead.next;
    }
}


