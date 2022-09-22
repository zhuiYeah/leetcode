package 二叉树

//287 / 332 个通过测试用例
//超出内存限制
func getDirections(root *TreeNode, startValue int, destValue int) string {
	father := map[int]*TreeNode{}
	var res string
	var start *TreeNode
	var constructFather func(root, from *TreeNode)
	constructFather = func(root, from *TreeNode) {
		if root == nil {
			return
		}
		if root.Val == startValue {
			start = root
		}
		father[root.Val] = from
		constructFather(root.Left, root)
		constructFather(root.Right, root)
	}

	var dfs func(root, from *TreeNode, path string) bool
	dfs = func(root, from *TreeNode, path string) bool {
		if root == nil {
			return false
		}
		if root.Val == destValue {
			res = path
			return true
		}
		if father[root.Val] != from {
			if dfs(father[root.Val], root, path+"U") {
				return true
			}
		}
		if root.Left != from {
			if dfs(root.Left, root, path+"L") {
				return true
			}
		}
		if root.Right != from {
			if dfs(root.Right, root, path+"R") {
				return true
			}
		}
		return false
	}
	constructFather(root, nil)
	dfs(start, nil, "")
	return res
}
