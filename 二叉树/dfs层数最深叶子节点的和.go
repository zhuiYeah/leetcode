package 二叉树

func deepestLeavesSum(root *TreeNode) int {
	sum := 0
	maxDepth := -1
	var dfs func(root *TreeNode, curLayer int)
	dfs = func(root *TreeNode, curLayer int) {
		if root == nil {
			return
		}
		if curLayer > maxDepth {
			maxDepth = curLayer
			sum = root.Val
		} else if curLayer == maxDepth {
			sum += root.Val
		}
		dfs(root.Left, curLayer+1)
		dfs(root.Right, curLayer+1)
	}
	dfs(root, 0)
	return sum
}
