package 链表

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l1 = reverseList(l1)
	l2 = reverseList(l2)
	fakeHead := &ListNode{-1, nil}
	tmp := fakeHead
	carry := 0
	for l1 != nil || l2 != nil {
		sum := 0
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		sum += carry
		carry = sum / 10
		val := sum % 10
		tmp.Next = &ListNode{val, nil}
		tmp = tmp.Next
	}
	if carry != 0 {
		tmp.Next = &ListNode{carry, nil}
	}

	return reverseList(fakeHead.Next)
}
