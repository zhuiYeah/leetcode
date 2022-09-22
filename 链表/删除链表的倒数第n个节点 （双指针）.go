package 链表

//快慢指针
func removeNthFromEnd0(head *ListNode, n int) *ListNode {
	fakeHead := &ListNode{-1, head}
	fast, slow := fakeHead, fakeHead

	for i := 0; i < n+1; i++ {
		fast = fast.Next
	}

	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	//现在slow的下一个节点就是要删除的节点
	slow.Next = slow.Next.Next
	return fakeHead.Next
}
