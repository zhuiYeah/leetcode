package 链表

import "math"

//毫无难点
func getDecimalValue(head *ListNode) int {
	n := getLen(head)
	fdewf := int(math.Pow(2.0, float64(n-1)))
	sum := 0
	for head != nil {
		sum += head.Val * fdewf
		fdewf /= 2
		head = head.Next
	}
	return sum
}
