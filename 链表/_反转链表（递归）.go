package 链表

// 想了很久
func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	if head.Next == nil { //链表中只有一个节点，反转这个链表后就是他的自身
		return head
	}
	newHead := reverseList(head.Next)
	//这一步太精髓了
	head.Next.Next = head
	head.Next = nil
	return newHead
}
