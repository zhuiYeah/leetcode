package 二叉树

//bfs
func rightSideView0(root *TreeNode) []int {
	var res []int
	nodeQueue := []*TreeNode{root}

	for len(nodeQueue) != 0 {
		n := len(nodeQueue)
		//每次进入这个for循环时，队列的长度就是当前层的节点个数，队列的最后一个节点就是当前层的最后一个节点
		for i := 0; i < n; i++ {
			node := nodeQueue[0]
			nodeQueue = nodeQueue[1:]
			if i == n-1 { //当前层的最后一个节点
				res = append(res, node.Val)
			}
			if node.Left != nil {
				nodeQueue = append(nodeQueue, node.Left)
			}
			if node.Right != nil {
				nodeQueue = append(nodeQueue, node.Right)
			}
		}
	}
	return res
}

//dfs
func rightSideView(root *TreeNode) []int {
	var res []int
	var dfs func(node *TreeNode, deep int)
	dfs = func(node *TreeNode, deep int) { //该函数实现了往res中添加第deep层的最后一个节点
		if node == nil {
			return
		}
		if len(res) == deep { //res的长度表明现在在第几层 ，按照 {根，[右子树的右先遍历],[左子树的右先遍历]}这样的遍历顺序，第一次访问到某一层时，必定先碰到该层最后一个点
			res = append(res, node.Val)
		}
		dfs(node.Right, deep+1)
		dfs(node.Left, deep+1)
	}
	dfs(root, 0)
	return res
}
