package 二叉树

import (
	"math"
	"strconv"
)

//这也算dfs哦
func printTree(root *TreeNode) [][]string {
	height := depth(root) - 1
	m := height + 1
	n := int(math.Pow(2.0, float64(height+1))) - 1
	res := make([][]string, m)
	for i := 0; i < m; i++ {
		res[i] = make([]string, n)
	}
	var dfs func(*TreeNode, int, int)
	dfs = func(root *TreeNode, curRow, curCol int) {
		if root == nil {
			return
		}
		res[curRow][curCol] = strconv.Itoa(root.Val)
		element := int(math.Pow(2.0, float64(height-curRow-1)))
		dfs(root.Left, curRow+1, curCol-element)
		dfs(root.Right, curRow+1, curCol+element)
	}
	dfs(root, 0, (n-1)/2)
	return res
}

func depth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l := depth(root.Left)
	r := depth(root.Right)
	return max(l, r) + 1
}
