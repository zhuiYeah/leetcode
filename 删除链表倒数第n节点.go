package main

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	//if n == 1 { //删除最后一个节点（想多了不需要考虑）
	//	p := head
	//	for p.Next.Next != nil {
	//		p = p.Next
	//	}
	//	p.Next = nil
	//	return head
	//}

	front := lengthOfList(head) - n //倒数第n个就是正数第front个（从0开始）
	if front == 0 {                 //删除头节点
		return head.Next
	}
	thePreviousNodeOfTheDeletedNode := head
	for i := 0; i < front-1; i++ {
		thePreviousNodeOfTheDeletedNode = thePreviousNodeOfTheDeletedNode.Next
	} //循环结束后，thePreviousNodeOfTheDeletedNode 指向被删除节点的前一个节点

	thePreviousNodeOfTheDeletedNode.Next = thePreviousNodeOfTheDeletedNode.Next.Next
	return head
}

//func lengthOfList(head *ListNode) int { //计算链表长度
//	length := 0
//	for head != nil {
//		head = head.Next
//		length++
//	}
//	return length
//}

func main() {
	head := &ListNode{Val: 0, Next: nil}
	head.Next = &ListNode{Val: 1, Next: nil}
	head.Next.Next = &ListNode{Val: 2, Next: nil}
	head.Next.Next.Next = &ListNode{Val: 3, Next: nil}
	println(lengthOfList(head))
	println(head.Val)
}
