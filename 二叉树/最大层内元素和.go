package 二叉树

import "math"

//找到二叉树元素和最大的一层，并返回该层的深度  （root节点的深度为1）
func maxLevelSum(root *TreeNode) int {
	var res int
	layer := 0              //记录当前所在第几层
	maxSum := math.MinInt32 //记录最大层和
	queue := []*TreeNode{root}
	for len(queue) != 0 {
		layer++
		n := len(queue)
		sumOfThisLayer := 0
		for i := 0; i < n; i++ {
			cur := queue[0]
			queue = queue[1:]
			if cur.Left != nil {
				queue = append(queue, cur.Left)
			}
			if cur.Right != nil {
				queue = append(queue, cur.Right)
			}
			sumOfThisLayer += cur.Val
		}
		if sumOfThisLayer > maxSum {
			maxSum = sumOfThisLayer
			res = layer
		}
	}
	return res
}
