package main

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	nodeOfHeadA := map[*ListNode]int{}
	for headA != nil {
		nodeOfHeadA[headA] = 0 //哈希表 value等于什么无所谓的，懂得都懂
		headA = headA.Next
	}
	for headB != nil {
		//如果nodeOfHeadA这个哈希表中 存在链表headB的 某一个节点，那么两个链表在这一点相交
		if _, ok := nodeOfHeadA[headB]; ok {
			return headB
		}
		headB = headB.Next
	}
	return nil
}

func main() {

}
