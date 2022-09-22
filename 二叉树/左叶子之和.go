package 二叉树

//左叶子之和非常适合层序遍历，但这里用了深度遍历
func sumOfLeftLeaves(root *TreeNode) int {
	res := 0
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		//前序遍历的逻辑
		if node.Left != nil && node.Left.Left == nil && node.Left.Right == nil {
			res += node.Left.Val
		}
		dfs(node.Left)
		dfs(node.Right)
	}
	dfs(root)
	return res
}
