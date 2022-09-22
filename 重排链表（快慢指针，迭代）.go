package main

import "fmt"

func reorderList(head *ListNode) {
	length := 0

	for head1 := head; head1 != nil; head1 = head1.Next {
		length++
	}
	stack := []*ListNode{}
	head1 := head

	for count := 0; head1.Next != nil; count++ {
		if count >= length/2 {
			stack = append(stack, head1.Next)
			head1.Next = head1.Next.Next
		} else {
			head1 = head1.Next
		}
	}
	//以上就是将链表中点之后的节点写入栈中
	//也可以用快慢指针找到中点，根据中点拆成两个链表 ；再将右边的链表逆序（迭代）；再直接合并两个链表

	head1 = head
	for len(stack) != 0 {
		tool := head1.Next
		head1.Next = stack[len(stack)-1]
		head1.Next.Next = tool
		head1 = tool
		stack = stack[:len(stack)-1]
	}

}
func main() {
	head := &ListNode{1, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{3, nil}
	head.Next.Next.Next = &ListNode{4, nil}
	head.Next.Next.Next.Next = &ListNode{5, nil}
	reorderList(head)
	for head != nil {
		fmt.Printf("%v --", head.Val)
		head = head.Next
	}
}
