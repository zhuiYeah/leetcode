package 链表

//快慢指针
func getKthFromEnd(head *ListNode, k int) *ListNode {
	fakeHead := &ListNode{114514, head}
	slow, fast := fakeHead, fakeHead
	for i := 0; i < k; i++ {
		fast = fast.Next
	}
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	return slow
}
