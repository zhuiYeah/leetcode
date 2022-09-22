package 链表

//秒杀
//交换链表正数第 k 个节点和倒数第 k 个节点的值
func swapNodes(head *ListNode, k int) *ListNode {
	//利用快慢指针获得倒数第k个节点
	slow, fast := head, head
	for i := 0; i < k; i++ {
		fast = fast.Next
	}
	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	//slow现在指向倒数第k个节点
	fast = head
	for i := 1; i < k; i++ {
		fast = fast.Next
	}
	//fast现在指向第k个节点
	slow.Val, fast.Val = fast.Val, slow.Val
	return head
}
