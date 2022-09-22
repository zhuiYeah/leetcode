package 二叉树

func hasPathSum(node *TreeNode, number int) bool { //从该节点到叶子节点，是否存在路径和为number
	if node == nil {
		return false
	}

	if node.Left == nil && node.Right == nil {
		return node.Val == number
	}

	return hasPathSum(node.Left, number-node.Val) || hasPathSum(node.Right, number-node.Val)
}
