package 链表;

//9.19 本题还是比较麻烦的
//调试很麻烦
//什么时候选择从长链表到短链表是关键
public class 分隔链表 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        var res = new ListNode[k];
        var tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        //每段链表的长度
        var per = len / k;
        if (len % k != 0) {
            per++;
        }
        var perLow = per - 1;
        int ptr = 0;
        while (head != null) {
            var realHead = head;
            for (int i = 0; i < per - 1; i++) {
                head = head.next;
            }
            tmp = head.next;
            head.next = null;
            head = tmp;
            len -= per;
            k--;
            res[ptr] = realHead;
            ptr++;
            if (perLow != 0 && perLow * k == len && len % perLow == 0) {
                per = perLow;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var x = new ListNode(1);
        var tmp = x;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        splitListToParts(x, 3);
    }
}
