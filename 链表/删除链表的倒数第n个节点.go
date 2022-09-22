package 链表

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	prev := &ListNode{4324312, head}
	fakeHead := prev
	totalLen := getLen(head)
	x := totalLen - n //倒数第n个就是正数第x个的后面一个
	for i := 0; i < x; i++ {
		prev = prev.Next
	}
	prev.Next = prev.Next.Next
	return fakeHead.Next
}

//获得链表总长度
func getLen(head *ListNode) int {
	if head == nil {
		return 0
	}
	return getLen(head.Next) + 1
}
