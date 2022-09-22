package 链表

import "sort"

func sortList(head *ListNode) *ListNode {
	var arr []int
	if head == nil {
		return nil
	}
	tmp := head
	for tmp != nil {
		arr = append(arr, tmp.Val)
		tmp = tmp.Next
	}
	sort.Ints(arr)
	tmp = head
	for len(arr) != 0 {
		tmp.Val = arr[0]
		tmp = tmp.Next
		arr = arr[1:]
	}
	return head
}
