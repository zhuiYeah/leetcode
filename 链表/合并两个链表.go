package 链表

//毫无难点，秒杀
func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
	head1 := list1
	for i := 1; i < a; i++ {
		head1 = head1.Next
	}
	head2 := head1.Next
	head1.Next = list2

	for i := 0; i < b-a+1; i++ {
		head2 = head2.Next
	}
	for list2.Next != nil {
		list2 = list2.Next
	}
	list2.Next = head2
	return list1
}
