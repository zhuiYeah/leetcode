package 递归

func hasPathSum(node *TreeNode, number int) bool { //从该节点到叶子节点，是否存在路径和为numbee
	if node == nil {
		return false
	}
	if node.Left == nil && node.Right == nil { //到达叶子节点时
		return node.Val == number
	}

	return hasPathSum(node.Left, number-node.Val) || hasPathSum(node.Right, number-node.Val) //左子树或者右子数是否存在路径和为number-node.Val
}
