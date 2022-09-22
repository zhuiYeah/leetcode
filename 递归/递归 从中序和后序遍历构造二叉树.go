package 递归

func buildTree(inorder []int, postorder []int) *TreeNode { //递归函数的功能是，给定一个子树前序遍历和中序遍历的序列化结果，构建这个子树
	if len(inorder) == 0 {
		return nil
	}
	l := len(inorder)
	root := &TreeNode{postorder[l-1], nil, nil}

	i := 0
	//找到中序遍历中根节点的位置i
	for ; i < l; i++ {
		if inorder[i] == postorder[l-1] {
			break
		}
	}
	lenOfLeft := i          //左子树长度
	lenOfRight := l - i - 1 //右子树长度
	root.Left = buildTree(inorder[:lenOfLeft], postorder[:lenOfLeft])
	root.Right = buildTree(inorder[l-lenOfRight:], postorder[lenOfLeft:l-1])
	return root
}
