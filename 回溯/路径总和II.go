package 回溯

//写的挺快，超越了100%
//二叉树从root到叶子节点所有和为targetSum的路径
func pathSum(root *TreeNode, targetSum int) [][]int {
	var res [][]int
	curSum := 0
	var backtracking func(node *TreeNode, path []int)
	backtracking = func(node *TreeNode, path []int) {
		if node == nil { //这也不算剪枝把，只是为了让这个回溯能够跑下去
			return
		}
		///对当前节点的处理放到了for循环的上面，这是本题的亮点
		curSum += node.Val
		path = append(path, node.Val)

		if node.Left == nil && node.Right == nil { //到达二叉树的叶子结点
			if curSum == targetSum {
				tmp := make([]int, len(path))
				copy(tmp, path)
				res = append(res, tmp)
			}
			return
		}
		//backtracking能走到这一步，说明当前节点不是叶子节点
		for i := 0; i < 2; i++ { //每层只有两个选择，左节点或是右节点
			if i == 0 {
				backtracking(node.Left, path)
			} else if i == 1 {
				backtracking(node.Right, path)
			}
			//回溯
			if i == 0 {
				if node.Left != nil {
					curSum -= node.Left.Val
				}
			} else if i == 1 {
				if node.Right != nil {
					curSum -= node.Right.Val
				}
			}
		}
	}
	backtracking(root, []int{})
	return res
}
