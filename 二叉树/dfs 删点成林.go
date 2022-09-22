package 二叉树

//删除二叉树里面的特定点，让二叉树变为很多个二叉树
func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	var res []*TreeNode
	if !check(to_delete, root.Val) {
		res = append(res, root)
	}
	var dfs func(root *TreeNode) *TreeNode
	dfs = func(root *TreeNode) *TreeNode {
		if root == nil {
			return nil
		}

		root.Left = dfs(root.Left)
		root.Right = dfs(root.Right)

		shouldWeDeleteThisNode := check(to_delete, root.Val)
		//这是个后序遍历的逻辑
		if shouldWeDeleteThisNode {
			if root.Left != nil {
				res = append(res, root.Left)
			}
			if root.Right != nil {
				res = append(res, root.Right)
			}
		}
		if shouldWeDeleteThisNode {
			return nil
		} else {
			return root
		}
	}
	dfs(root)
	//for i := 0; i < len(res); i++ {
	//	if check(to_delete, res[i].Val) {
	//		res = append(res[:i], res[i+1:]...)
	//		i--
	//	}
	//}
	return res

}

func check(delete []int, x int) bool {
	for i := 0; i < len(delete); i++ {
		if delete[i] == x {
			return true
		}
	}
	return false
}
