package main

func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	length := getLength(head) //得到链表长度
	tail := head
	node := head //node指针不断滑动到奇数节点 和 链接到奇数节点

	for tail.Next != nil {
		tail = tail.Next
	} //此for循环结束后，tail指针变为尾巴指针

	for i := 0; i < length/2; i++ {
		tail.Next = node.Next //新增尾节点
		tail = tail.Next      //滑动至新的尾节点
		node.Next = tail.Next //node节点链接至奇数节点上
		node = node.Next      //node节点滑动到下一个奇数节点
		tail.Next = nil       //断掉尾节点的指向，避免链表成为回环链表

	}

	return head

}

func getLength(node *ListNode) int {
	n := 0
	for node != nil {
		node = node.Next
		n++
	}
	return n
}

func main() {

}
