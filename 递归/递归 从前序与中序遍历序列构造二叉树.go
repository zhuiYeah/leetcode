package 递归

func buildTree0(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	l := len(preorder)
	root := &TreeNode{preorder[0], nil, nil}
	i := 0
	for ; i < l; i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}
	lenOfLeft := i
	lenOfRight := len(preorder) - 1 - i
	root.Left = buildTree(preorder[1:1+lenOfLeft], inorder[:lenOfLeft])
	root.Right = buildTree(preorder[l-lenOfRight:], inorder[l-lenOfRight:])
	return root
}

func main() {
	preorder := []int{3, 9, 20, 15, 7}
	inorder := []int{9, 3, 15, 20, 7}
	buildTree(preorder, inorder)

}
