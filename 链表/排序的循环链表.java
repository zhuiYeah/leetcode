package 链表;

//剑指offer
public class 排序的循环链表 {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        var tmp = head;
        if (head == null) {
            tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        for (int count = 0; ; tmp = tmp.next, count++) {
            if (tmp.next.val < tmp.val && (insertVal >= tmp.val || insertVal <= tmp.next.val) || insertVal >= tmp.val && insertVal <= tmp.next.val || count > 50000) {
                var xxx = tmp.next;
                tmp.next = new Node(insertVal);
                tmp.next.next = xxx;
                break;
            }
        }
        return head;
    }
}

//            //表明当前节点是链表的最后一个节点
//            if (tmp.next.val < tmp.val && (insertVal >= tmp.val || insertVal <= tmp.next.val)) {
//                var xxx = tmp.next;
//                tmp.next = new Node(insertVal);
//                tmp.next.next = xxx;
//                break;
//            }
//            if (insertVal >= tmp.val && insertVal <= tmp.next.val) {
//                var xxx = tmp.next;
//                tmp.next = new Node(insertVal);
//                tmp.next.next = xxx;
//                break;
//            }
//            if (count > 50000){
//                var xxx = tmp.next;
//                tmp.next = new Node(insertVal);
//                tmp.next.next = xxx;
//                break;
//            }
