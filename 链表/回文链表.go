package 链表

func isPalindrome(head *ListNode) bool {
	var x []int
	for head != nil {
		x = append(x, head.Val)
		head = head.Next
	}
	p, q := 0, len(x)-1
	for p < q {
		if x[p] != x[q] {
			return false
		}
		p++
		q--
	}
	return true
}
