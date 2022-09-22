package main

//type Node struct {
//	Val   int
//	Prev  *Node
//	Next  *Node
//	Child *Node
//}

//func flatten(root *Node) *Node {
//	if root == nil {
//		return root
//	}
//	node := root
//	headOfNext := root
//	for {
//		if node.Child != nil { //更换child和next
//			headOfNext = node.Child
//			node.Child = node.Next
//			if node.Child != nil {
//				node.Child.Prev = nil
//			} //更换child和next后要使child不能回溯到node
//			node.Next = headOfNext
//			node.Next.Prev = node //使其成为双向链表
//		}
//		if node.Next == nil { //到达尾节点就退出
//			break
//		} else {
//			node = node.Next
//		}
//	}
//	tail := node //tail现在尾巴节点
//
//	for { //往回遍历
//		if node.Child != nil {
//			tail.Next = node.Child //Child链接到链表最后面
//			tail.Next.Prev = tail  //双向链表呀
//			node.Child = nil
//			tail = ReturnLastNode(tail) //新的尾巴节点
//		}
//		if node.Prev == nil {
//			break
//		} else {
//			node = node.Prev
//		}
//	}
//
//	return root
//}
//
//// ReturnLastNode 返回链表的最后一个节点
//func ReturnLastNode(tail *Node) *Node {
//	for tail.Next != nil {
//		tail = tail.Next
//	}
//	return tail
//}
//
////找到一行链表的最后一个节点；找到一行链表有child指针的节点并删除这个节点的child指针
//func findLastAndChildWhileDeleteChild(head *Node) (tail *Node, headOfChild *Node) {
//	headOfChild = nil
//	for {
//		if head.Child != nil { //找到一行链表的child节点
//			headOfChild = head.Child
//			head.Child = nil //删掉这个节点的child指针
//		}
//
//		if head.Next == nil { //到达一行链表的最后一个节点退出循环
//			break
//		} else {
//			head = head.Next
//		}
//	}
//	tail = head
//	return tail, headOfChild
//}

func main() {

}
