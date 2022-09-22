package main

//type Node struct {
//	Val    int
//	Next   *Node
//	Random *Node
//}

//func copyRandomList(head *Node) *Node {
//	if head == nil {
//		return nil
//	}
//	myHead := &Node{head.Val, nil, nil} //新开辟一块新的空间作为新链表的头节点
//	node := myHead                      //node用作操作myHead链表
//	head2 := head
//	pointerMatchMap := map[*Node]*Node{head: myHead} //pointerMatchMap  key：原始链表的指针   value：新建链表的指针
//
//	//这个for循环之后，新链表链接完成（除了Random指针），hashmap填入完成
//	for {
//		head = head.Next
//		if head == nil {
//			break
//		}
//		node.Next = &Node{head.Val, nil, nil}
//		node = node.Next
//		pointerMatchMap[head] = node
//	}
//	pointerMatchMap[head] = node.Next //最后一个空地址也要存入，head此时指向原始链表的最后一个地址，node指向新链表的最后一个节点
//
//	node = myHead //node回溯到起点
//	//本次循环，匹配哈希表，完成新链表的Random指针
//	for head2 != nil {
//		node.Random = pointerMatchMap[head2.Random]
//		node = node.Next
//		head2 = head2.Next
//	}
//	return myHead
//
//}
