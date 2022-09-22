package 链表

func addTwoNumbers0(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	head := &ListNode{-1, nil}
	prev := head
	for l1 != nil && l2 != nil {
		num := l1.Val + l2.Val + carry
		carry = num / 10
		prev.Next = &ListNode{num % 10, nil}
		prev = prev.Next
		l1 = l1.Next
		l2 = l2.Next //l1=l2.Next 卧槽尼玛 ，一个小错误debug要了人的命！
	}
	for l1 != nil {
		num := l1.Val + carry
		carry = num / 10
		prev.Next = &ListNode{num % 10, nil}
		prev = prev.Next
		l1 = l1.Next
	}

	for l2 != nil {
		num := l2.Val + carry
		carry = num / 10
		prev.Next = &ListNode{num % 10, nil}
		prev = prev.Next
		l2 = l2.Next
	}

	if carry != 0 {
		prev.Next = &ListNode{carry, nil}
	}

	return head.Next
}

func main() {
	l1 := &ListNode{5, nil}
	l1.Next = &ListNode{6, nil}
	l1.Next.Next = &ListNode{4, nil}

	l2 := &ListNode{2, nil}
	l2.Next = &ListNode{4, nil}
	l2.Next.Next = &ListNode{3, nil}

	addTwoNumbers(l1, l2)
}
