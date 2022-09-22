package 递归

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	node := reverseList(head.Next) //获取除了head之后的反转链表
	head.Next.Next = head
	head.Next = nil
	return node
}
