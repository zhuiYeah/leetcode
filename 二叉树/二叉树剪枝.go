package 二叉树

func pruneTree(root *TreeNode) *TreeNode { //这必定是一个后序遍历的逻辑
	if root == nil {
		return nil
	}
	root.Left = pruneTree(root.Left)
	root.Right = pruneTree(root.Right)
	if root.Left == nil && root.Right == nil && root.Val == 0 {
		return nil
	}
	return root
}
