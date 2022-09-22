package 递归

func insertIntoBST(root *TreeNode, val int) *TreeNode {
	if root == nil { //递归终止条件，当然到叶子节点才能插入
		return &TreeNode{val, nil, nil}
	}

	if val > root.Val { //如果要插入的值比root的值大，往root的右边插
		root.Right = insertIntoBST(root.Right, val)
	}
	if val < root.Val { //否则往左边插
		root.Left = insertIntoBST(root.Left, val)
	}

	return root //左边右边插完了就返回啊
}
