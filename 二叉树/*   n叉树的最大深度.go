package 二叉树

func maxDepth(root *Node) int {
	if root == nil {
		return 0
	}
	x := 0
	for i := 0; i < len(root.Children); i++ {
		x = max(x, maxDepth(root.Children[i]))
	}
	//x目前是所有子树中最深的子树长度
	return x + 1
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
