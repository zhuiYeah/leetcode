package 二叉树

//type Node struct {
//	Val   int
//	Left  *Node
//	Right *Node
//	Next  *Node
//}
//
//func connect(root *Node) *Node {
//	if root == nil {
//		return nil
//	}
//	queue := []*Node{root}
//	for len(queue) != 0 {
//		n := len(queue) // 当前需要遍历层的长度
//		for i := 0; i < n; i++ {
//			node := queue[0]
//			queue = queue[1:]
//			if node.Left != nil {
//				queue = append(queue, node.Left)
//			}
//			if node.Right != nil {
//				queue = append(queue, node.Right)
//			}
//			if i != n-1 { //最后一个点不用链接
//				node.Next = queue[0]
//			}
//		}
//
//	}
//	return root
//}
