package 二叉树

import "math"

func largestValues(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}
	queue := []*TreeNode{root}
	for len(queue) != 0 {
		n := len(queue)
		curMax := math.MinInt32
		for i := 0; i < n; i++ {
			cp := queue[0]
			queue = queue[1:]
			curMax = max(curMax, cp.Val)
			if cp.Left != nil {
				queue = append(queue, cp.Left)
			}
			if cp.Right != nil {
				queue = append(queue, cp.Right)
			}
		}
		res = append(res, curMax)
	}
	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
