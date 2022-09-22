package 二叉树

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if root == nil {
		return false
	}
	return isSameTree1(root, subRoot) || isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}

//一个树是另一个树的子树 则
//
//要么这两个树相等
//要么这个树是左树的子树
//要么这个树是右树的子树

func isSameTree1(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	//前序遍历的逻辑，从上往下遍历，只要有不同点了，那么就不是相同的树
	if p.Val != q.Val {
		return false
	}
	return isSameTree1(p.Left, q.Left) && isSameTree1(p.Right, q.Right)
}
