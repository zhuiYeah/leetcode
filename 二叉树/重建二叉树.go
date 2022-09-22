package 二叉树

//从前序遍历和中序遍历构建二叉树
//构建二叉树这一行为必须是前序遍历的逻辑
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	root := &TreeNode{preorder[0], nil, nil}
	i := 0
	for i = 0; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}

	root.Left = buildTree(preorder[1:1+i], inorder[:i])
	root.Right = buildTree(preorder[1+i:], inorder[i+1:])
	return root
}

