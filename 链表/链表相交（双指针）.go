package 链表

func getIntersectionNode0(headA, headB *ListNode) *ListNode {
	lenA := getLen(headA)
	lenB := getLen(headB)
	diff := lenA - lenB
	if diff > 0 {
		for i := 0; i < diff; i++ {
			headA = headA.Next
		}
	}
	if diff < 0 {
		for i := 0; i < -diff; i++ {
			headB = headB.Next
		}
	}
	//以上就是为了让指针headA，headB指向相同的位置
	for headA != nil && headB != nil {
		if headB == headA {
			return headA
		}
		headA = headA.Next
		headB = headB.Next
	}
	return nil
}
