package 二叉树

import "strconv"

func binaryTreePaths(root *TreeNode) []string {
	var res []string
	var dfs func(node *TreeNode, path string)
	dfs = func(node *TreeNode, path string) {
		if node == nil { //碰到空节点啥也不用做
			return
		}
		
		if node.Left == nil && node.Right == nil { //叶子结点，碰到叶子结点，需要往res里面收集路径了
			v := path + strconv.Itoa(node.Val)
			res = append(res, v)
			return
		}
		//前序遍历的逻辑
		path += strconv.Itoa(node.Val) + "->"
		dfs(node.Left, path)
		dfs(node.Right, path)

	}
	dfs(root, "")
	return res
}
