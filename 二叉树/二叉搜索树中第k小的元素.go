package 二叉树

func kthSmallest(root *TreeNode, k int) int {
	var arr []int
	var inorder func(root *TreeNode)
	inorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		//if len(arr) == k { //中序遍历到第k个停止
		//	return
		//}
		inorder(root.Left)
		if len(arr) == k { //中序遍历到第k个停止  思考一下为什么把截止放在这里呢 ，截止操作放在数组添加元素之前
			return
		}
		arr = append(arr, root.Val)
		inorder(root.Right)
	}
	inorder(root)
	return arr[len(arr)-1]
}
