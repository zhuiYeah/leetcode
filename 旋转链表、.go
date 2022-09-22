package main

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	length := lengthOfList(head)

	for i := 0; i < k%length; i++ {
		thePenultimateNode := returnPenultimateNode(head)
		thePenultimateNode.Next.Next = head
		head = thePenultimateNode.Next
		thePenultimateNode.Next = nil
	}
	return head

}

//返回倒数第二个节点
func returnPenultimateNode(head *ListNode) *ListNode {
	for head.Next.Next != nil {
		head = head.Next
	}
	return head
}

func lengthOfList(head *ListNode) int { //计算链表长度
	length := 0
	for head != nil {
		head = head.Next
		length++
	}
	return length
}
