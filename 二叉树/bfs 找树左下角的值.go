package 二叉树

//从右向左进行层序遍历，队列中的最后一个点就是树最左下角的点
func findBottomLeftValue(root *TreeNode) int {
	queue := []*TreeNode{root}
	var res int
	for len(queue) != 0 {
		cp := queue[0]
		queue = queue[1:]
		res = cp.Val
		if cp.Right != nil {
			queue = append(queue, cp.Right)
		}
		if cp.Left != nil {
			queue = append(queue, cp.Left)
		}
	}
	return res
}
