package 二叉树

type Node struct {
	Val      int
	Children []*Node
}

func levelOrder(root *Node) [][]int {
	var res [][]int
	if root == nil {
		return res
	}
	queue := []*Node{root}
	for len(queue) != 0 {
		n := len(queue)                  //n是本层的全部元素个数
		var AllElementsOfThisLayer []int //用来储存本层的元素
		for i := 0; i < n; i++ {         //从队列中取出n个节点写进数组中，同时将这n个节点的子节点全部写进queue
			node := queue[0]
			queue = queue[1:]
			AllElementsOfThisLayer = append(AllElementsOfThisLayer, node.Val)
			for j := 0; j < len(node.Children); j++ {
				queue = append(queue, node.Children[j])
			}
		}
		res = append(res, AllElementsOfThisLayer)
	}
	return res
}
