package 二叉树

//反中序遍历
func convertBST(root *TreeNode) *TreeNode {
	var convertInorder func(root *TreeNode)
	curSum := 0 //全局变量记录当前遍历所有节点的累加和
	convertInorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		convertInorder(root.Right)
		tmp := root.Val //先存一下当前节点的初始值
		root.Val += curSum
		curSum += tmp
		convertInorder(root.Left)
	}
	convertInorder(root)
	return root
}
