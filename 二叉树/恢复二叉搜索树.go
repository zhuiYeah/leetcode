package 二叉树

//BST中有两个点出错了 ， 将它恢复为正确的BST
///笨方法，也获得了不错的效率
func recoverTree(root *TreeNode) {
	var err1 *TreeNode
	var err2 *TreeNode
	var res []int
	var inorder func(root *TreeNode)
	inorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		inorder(root.Left)
		res = append(res, root.Val)
		inorder(root.Right)
	}
	inorder(root)
	//以上就是获得BST的中序遍历
	index1 := 0
	for i := 1; i < len(res); i++ {
		if res[i] < res[i-1] {
			index1 = i - 1
			break
		}
	}
	index2 := -1
	for i := index1 + 1; i < len(res)-1; i++ {
		if res[i] > res[i+1] {
			index2 = i + 1
			break
		}
	}
	if index2 == -1 {
		index2 = index1 + 1
	}
	num1 := res[index1]
	num2 := res[index2]
	//以上获得两个出错节点的值
	var inorder2 func(root *TreeNode)
	inorder2 = func(root *TreeNode) {
		if root == nil {
			return
		}
		inorder2(root.Left)
		if root.Val == num1 {
			err1 = root
		} else if root.Val == num2 {
			err2 = root
		}
		inorder2(root.Right)
	}
	inorder2(root)
	//以上找到两个出错点
	err1.Val, err2.Val = err2.Val, err1.Val
}
