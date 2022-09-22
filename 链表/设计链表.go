package 链表

type MyLinkedList struct {
	head *ListNode //链表头节点(并不是链表的真正头节点，是一个哨兵节点？？)
	size int       //记录链表总长度
}

func Constructor() MyLinkedList {
	return MyLinkedList{&ListNode{}, 0} //这里的节点是实际上链表的第一个节点，但是我们需要构造的链表不存在这个节点
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || index >= this.size {
		return -1
	}
	prev := this.head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}
	return prev.Next.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	this.AddAtIndex(0, val)
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.AddAtIndex(this.size, val)
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 || index > this.size {
		return
	}
	prev := this.head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}
	prev.Next = &ListNode{val, prev.Next}
	this.size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || index >= this.size {
		return
	}
	prev := this.head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}
	prev.Next = prev.Next.Next
	this.size--
}
