package 递归

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxPathSum(root *TreeNode) int {
	maxSum := math.MinInt
	var dfs2 func(*TreeNode) int
	dfs2 = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		//计算左边分支最大值，如果小于0还不如不要
		leftMax := max(dfs2(root.Left), 0)
		//计算右边分支最大值，如果小于0还不如不要
		rightMax := max(0, dfs2(root.Right))
		// left->root->right 作为路径与已经计算过历史最大值做比较
		maxSum = max(maxSum, root.Val+leftMax+rightMax)
		// 返回经过root的单边最大分支给当前root的父节点计算使用
		return root.Val + max(leftMax, rightMax)
	}
	dfs2(root)
	return maxSum
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
