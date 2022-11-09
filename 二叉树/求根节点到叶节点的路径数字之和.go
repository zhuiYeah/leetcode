package 二叉树

//本题深搜多少是带点回溯的东西在里面的
func sumNumbers(root *TreeNode) int {
	res := 0
	var dfs func(root *TreeNode, curSum int)
	dfs = func(root *TreeNode, curSum int) {
		if root == nil {
			return
		}
		curSum = curSum*10 + root.Val
		if root.Left == nil && root.Right == nil { //叶子结点,收集结果
			res += curSum
			return
		}
		//走到这一步说明不是叶子节点
		dfs(root.Left, curSum)
		dfs(root.Right, curSum)
	}
	dfs(root, 0)
	return res
}
