package 二叉树

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if p.Val < root.Val && q.Val < root.Val { //pq都在root的左边
		return lowestCommonAncestor(root.Left, p, q)
	}
	if p.Val > root.Val && q.Val > root.Val { //pq都在root的右边
		return lowestCommonAncestor(root.Right, p, q)
	}
	//pq在root的一左一右
	return root
}
