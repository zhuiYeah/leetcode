package 二叉树

//func diameterOfBinaryTree(root *TreeNode) int {
//	maxL := math.MinInt32
//	var xxx func(root *TreeNode)
//	xxx = func(root *TreeNode) {
//		if root == nil {
//			return
//		}
//		leftMax := getLen(root.Left) //这里每一层都要求左右子树的深度，是做了大量重复计算的
//		rightMax := getLen(root.Right)
//		maxL = max(maxL, 1+leftMax+rightMax)
//		diameterOfBinaryTree(root.Left)
//		diameterOfBinaryTree(root.Right)
//	}
//	xxx(root)
//	return maxL
//}
//
//func getLen(root *TreeNode) int {
//	if root == nil {
//		return 0
//	}
//	return max(getLen(root.Left), getLen(root.Right)) + 1
//}

//优化版 ，优化了写法，把每个节点单独求高度 和 计算直径 融合进了一个函数  ，大大减少了重复计算
func diameterOfBinaryTree(root *TreeNode) int {
	dia := 0
	var lastorder func(root *TreeNode) int
	lastorder = func(root *TreeNode) int { //
		if root == nil {
			return 0
		}
		leftTreeHigh := lastorder(root.Left)
		rightTreeHigh := lastorder(root.Right)
		dia = max(dia, leftTreeHigh+rightTreeHigh) //后序遍历，从下往上计算每一个节点的直径

		return max(leftTreeHigh, rightTreeHigh) + 1 //给他的父节点返回该条路径的最大高度
	}
	lastorder(root)
	return dia
}
