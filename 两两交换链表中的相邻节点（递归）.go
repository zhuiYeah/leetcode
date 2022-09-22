package main

//迭代
func swapPairs0(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	if head.Next == nil {
		return head
	}
	NewHead := head.Next
	head.Next = head.Next.Next
	NewHead.Next = head
	for head.Next != nil {
		tool := head.Next
		if tool.Next == nil {
			break
		}
		head.Next = head.Next.Next
		tool.Next = tool.Next.Next
		head.Next.Next = tool
		head = tool
	}
	return NewHead
}

//递归
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	newHead := head.Next
	head.Next = swapPairs(head.Next.Next)
	newHead.Next = head
	return newHead
}
