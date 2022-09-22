package main

//利用快慢指针，环形链表，快指针必定能追上慢指针
func hasCycle(node *ListNode) bool {
	if node == nil { //空链表必定不是回环链表
		return false
	}
	p, q := node, node.Next //慢指针和快指针

	for {
		if p == nil || q == nil { //一个回环链表是不会有空指针的，因为它不存在叶子节点
			return false
		}

		if p == q { // 快指针追上了慢指针，必定是回环链表
			return true
		}

		p = p.Next         //慢指针走一步
		if q.Next != nil { //为了避免快指针步子迈得太大扯着蛋，如果快指针的下一个指针指向空节点，则立刻断定为非回环链表
			q = q.Next.Next //快指针走两步
		} else {
			return false
		}
	}
}

//利用哈希表，遍历链表，每个节点写入哈希表，一旦匹配到哈希表中已存在的key值（指针值），那么立刻断定为回环链表
func hasCycle2(node *ListNode) bool { //那么如何唯一的确定一个节点呢？ 其中储存的数字显然不可能，只有指针，每个指针指向独一无二的内存空间
	seen := map[*ListNode]int{}

	for node != nil {
		if _, ok := seen[node]; ok == true {
			return true
		} else {
			seen[node] = 84972343289
		}
		node = node.Next
	}

	return false
}
