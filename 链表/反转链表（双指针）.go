package 链表

func reverseList1(head *ListNode) *ListNode {
	cur := head
	var pre *ListNode
	for cur != nil {
		tmp := cur
		cur = cur.Next
		tmp.Next = pre
		pre = tmp
	}
	return pre
}
