package 二叉树

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//这里path不作为全局变量，回溯阶段不需要处理path
//而本题用java写的path不作为全局变量，回溯阶段需要处理path，这是为什么呢？
//猜测是由于List<>以及[]int 这些数据结构造成的
func pathSum3(root *TreeNode, targetSum int) [][]int {
	var res [][]int
	curSum := 0
	var backtracking func(node *TreeNode, path []int)
	backtracking = func(node *TreeNode, path []int) {
		if node == nil { //这也不算剪枝把，只是为了让这个回溯能够跑下去
			return
		}
		//对当前节点的处理放到了for循环的上面
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////	////////////////////////////////////////////////////////////////
//path作为全局变量，回溯必须要维护path
//curSum作为参数传递，回溯不需要维护curSum
func pathSum2(root *TreeNode, targetSum int) [][]int {
	var res [][]int
	var path []int
	var backtracking func(node *TreeNode, curSum int)
	backtracking = func(node *TreeNode, curSum int) {
		if node == nil { //这也不算剪枝把，只是为了让这个回溯能够跑下去
			return
		}
		curSum += node.Val //对当前节点的处理放到了for循环的上面
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
				backtracking(node.Left, curSum)
			} else if i == 1 {
				backtracking(node.Right, curSum)
			}
			//回溯
			if i == 0 {
				if node.Left != nil {
					//curSum -= node.Left.Val
					path = path[:len(path)-1]
				}
			} else if i == 1 {
				if node.Right != nil {
					//curSum -= node.Right.Val
					path = path[:len(path)-1]
				}
			}
		}
	}
	backtracking(root, 0)
	return res
}
