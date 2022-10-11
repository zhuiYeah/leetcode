package 链表;

import java.util.HashSet;

//链表中连续的一段元素全部在nums之中的话，那么这段元素组成的集合可以称作是链表的一个组件，返回链表的组件数目
public class 链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        var noSeen = new HashSet<Integer>();
        for (int num : nums) {
            noSeen.add(num);
        }
        int res = 0;
        //当前节点的前一个节点是否是组件的一部分
        boolean pre = false;
        for (var i = head; i != null; i = i.next) {
            if (noSeen.contains(i.val)) {
                pre = true;
                noSeen.remove(i.val);
            } else {
                if (pre) {
                    res++;
                    pre = false;
                }
            }
        }
        if (pre) res++;
        return res;
    }
}
