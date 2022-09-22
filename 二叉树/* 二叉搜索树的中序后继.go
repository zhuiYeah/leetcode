package 二叉树

//如果p节点有右子树，那么返回其右子树最左边的节点
//如果p无右子树，需要返回p所在的左子树的根节点（应该尽量接近p）
//其余情况返回null
func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode { //找到p的后继
	if root == nil {
		return nil
	}
	res := &TreeNode{}
	res = nil
	for root != nil {
		if root.Val > p.Val {
			res = root
			root = root.Left
		} else if root.Val < p.Val {
			root = root.Right
		} else {
			if root.Right == nil {
				break
			} else {
				root = root.Right
				for root != nil {
					res = root
					root = root.Left
				}
			}
		}
	}
	return res
}
