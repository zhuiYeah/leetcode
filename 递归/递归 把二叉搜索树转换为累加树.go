package 递归

//反中序遍历 右- >中 ->左  BST的反中序遍历是递减的

func convertBST(root *TreeNode) *TreeNode {
	sum := 0
	var convertInorder func(node *TreeNode)
	convertInorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		convertInorder(node.Right)
		x := node.Val //拿这个点暂存节点的值啊，第一次写的时候就是忽略了这一点
		node.Val += sum
		sum += x
		convertInorder(node.Left)
	}
	convertInorder(root)
	return root
}
