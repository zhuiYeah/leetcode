package 链表

//找到环的入口点
func detectCycle(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast { //快慢指针相遇了
			for slow != head { //让慢指针与head指针一起移动，相遇点一定是环的入口点（数学推导）
				slow = slow.Next
				head = head.Next
			}
			return head
		}
	}
	return nil
}
