package 二叉树

//对二叉树中的每个节点（顺序无所谓吧，前中后都可以）都要向下进行深度搜索
func pathSum(root *TreeNode, targetSum int) int {
	numOfPaths := 0
	var dfs func(node *TreeNode, curSum int)
	//函数dfs用于对于固定节点node开始，找到所有起点为node、和为target的路径
	dfs = func(node *TreeNode, curSum int) {
		if node == nil {
			return
		}
		//走到这里node就不是空节点
		curSum += node.Val
		if curSum == targetSum { //找到一条路径了，不要return！！ 继续往下找！
			numOfPaths++
		}
		dfs(node.Left, curSum)
		dfs(node.Right, curSum)
	}

	var xxorder func(root *TreeNode) //遍历二叉树中的每个节点（遍历顺序无所谓），以这些节点作为起始节点往下搜索全部路径
	xxorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root, 0)
		xxorder(root.Left)
		xxorder(root.Right)
	}
	xxorder(root)
	return numOfPaths
}

//为什么不把两个dfs写成一个呢，那种情况见二叉树的直径，那是在一个递归里面做了两样事情，是可以合并在一起的，这里合并的话很难，或者不可能或者我不会
func pathSum1(root *TreeNode, sum int) int {
	res := 0
	var serachPath func(node *TreeNode, curSum int)
	serachPath = func(node *TreeNode, curSum int) {
		if node == nil {
			return
		}
		curSum += node.Val
		if curSum == sum {
			res++
		}
		serachPath(node.Left, curSum)
		serachPath(node.Right, curSum)
	}
	var preorder func(node *TreeNode)
	preorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		serachPath(root, 0)
		preorder(root.Left)
		preorder(root.Right)
	}
	preorder(root)
	return res
}
