package main

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	leftOfLeft := head
	RightOfRight := head
	head1 := head

	for count := 1; head1 != nil; count++ {
		if count == left-1 {
			leftOfLeft = head1
		}
		if count == right {
			RightOfRight = head1.Next
			head1.Next = nil
			break
		}
		head1 = head1.Next
	}
	leftP := leftOfLeft.Next
	if left == 1 {
		leftP = head
	}
	//从leftP开始是一个新链表，反转这个新链表

	NewHead := leftP
	for leftP.Next != nil {
		tool := leftP.Next
		leftP.Next = leftP.Next.Next
		tool.Next = NewHead
		NewHead = tool
	}

	//再与之前截断的部分对接
	leftP.Next = RightOfRight
	if left == 1 {
		return NewHead
	}
	leftOfLeft.Next = NewHead

	return head

}
