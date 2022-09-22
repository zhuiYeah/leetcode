package main

import "fmt"

//83 删除链表的多余元素

func deleteDuplicates(head *ListNode) *ListNode {
	if head.Next == nil || head == nil {
		return head
	}
	p1 := head
	p2 := head.Next
	for p2.Next != nil {
		if p2.Val == p1.Val {
			p1.Next = p2.Next
			p2 = p2.Next
		} else {
			p1 = p1.Next
			p2 = p2.Next
		}
	}
	if p1.Val == p2.Val {
		p1.Next = p2.Next
	}
	return head
}

func main() {
	a := &ListNode{}
	deleteDuplicates(a)
	fmt.Printf("%v\n", a)
}
