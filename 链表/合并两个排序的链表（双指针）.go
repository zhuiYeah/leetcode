package 链表

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	fakeHead := &ListNode{114514, nil}
	p := fakeHead
	for l1 != nil && l2 != nil {
		if l1.Val > l2.Val {
			p.Next = l2
			p = p.Next
			l2 = l2.Next
		} else {
			p.Next = l1
			l1 = l1.Next
			p = p.Next
		}
	}
	if l1 != nil {
		p.Next = l1
	}
	if l2 != nil {
		p.Next = l2
	}
	return fakeHead.Next
}
