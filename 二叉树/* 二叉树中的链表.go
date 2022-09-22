package 二叉树

//二叉树中包含链表吗？ 不会
func isSubPath(head *ListNode, root *TreeNode) bool {
	if head == nil && root == nil {
		return true
	}
	if head == nil && root != nil {
		return true
	}
	if head != nil && root == nil {
		return false
	}

	for head.Val != root.Val {
		isSubPath(head, root.Left)
		isSubPath(head, root.Right)
	}
	if head.Val == root.Val {
		if isSubPath(head.Next, root.Left) {
			return true
		}
		if isSubPath(head.Next, root.Right) {
			return true
		}
	}

	return false
}
