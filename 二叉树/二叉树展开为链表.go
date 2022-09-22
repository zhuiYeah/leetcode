package 二叉树

//秒杀
func flatten(root *TreeNode) {
	var arr []int
	var preorder func(node *TreeNode)
	//先获得二叉树前序遍历的结果
	preorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		arr = append(arr, node.Val)
		preorder(node.Left)
		preorder(node.Right)
	}
	preorder(root)
	if len(arr) == 0 {
		return
	}
	//开始改造这颗二叉树
	arr = arr[1:]
	root.Left = nil
	for len(arr) != 0 {
		root.Right = &TreeNode{arr[0], nil, nil}
		arr = arr[1:]
		root = root.Right
	}
}
