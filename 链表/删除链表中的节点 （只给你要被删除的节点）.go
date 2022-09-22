package 链表

//删除链表中的node节点 node一定不是尾巴节点
func deleteNode(node *ListNode) {
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
