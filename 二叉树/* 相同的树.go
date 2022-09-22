package 二叉树

func isSameTree(p, q *TreeNode) bool { //判断两颗二叉树是否完全相同
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
