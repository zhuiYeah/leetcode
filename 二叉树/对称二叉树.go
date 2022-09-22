package 二叉树

func isSymmetric(root *TreeNode) bool {
	var check func(*TreeNode, *TreeNode) bool
	check = func(node1 *TreeNode, node2 *TreeNode) bool {
		if node1 == nil && node2 == nil {
			return true
		}
		if node1 == nil || node2 == nil {
			return false
		}
		if node1.Val != node2.Val {
			return false
		}
		return check(node1.Left, node2.Right) && check(node1.Right, node2.Left)
	}
	return check(root.Left, root.Right)
}
