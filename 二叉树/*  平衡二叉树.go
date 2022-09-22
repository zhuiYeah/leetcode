package 二叉树

import "math"

func isBalanced(node *TreeNode) bool {
	if node == nil {
		return true
	}
	if !isBalanced(node.Left) || !isBalanced(node.Right) {
		return false
	}
	//后序遍历的单层逻辑，从下往上判断
	if math.Abs(float64(maxDeath(node.Left)-maxDeath(node.Right))) > 1 {
		return false
	}
	return true
}

func maxDeath(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := maxDeath(node.Left)
	right := maxDeath(node.Right)
	return max(left, right) + 1
}
