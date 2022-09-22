package 二叉树

import "strconv"

//原来这也叫深度优先搜索
func tree2str(root *TreeNode) string {
	if root == nil {
		return ""
	}
	s := strconv.Itoa(root.Val)
	left := tree2str(root.Left)
	right := tree2str(root.Right)
	if left == "" && right != "" {
		s += "()" + "(" + right + ")"
	} else if left != "" && right == "" {
		s += "(" + left + ")"
	} else if left != "" && right != "" {
		s += "(" + left + ")" + "(" + right + ")"
	}
	return s
}
