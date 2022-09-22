package 二叉树

func levelOrderBottom(root *TreeNode) [][]int {
	queue := []*TreeNode{root}
	var res [][]int
	for len(queue) != 0 {
		res = append(res, []int{})
		x := len(queue)          //当前层的总节点个数
		for i := 0; i < x; i++ { //遍历当前层的所有节点
			node := queue[0]
			queue = queue[1:]

			res[len(res)-1] = append(res[len(res)-1], node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
	adverse(res)
	return res
}

func adverse(nums [][]int) { //这居然是个引用传递？？
	for i := 0; i < len(nums)/2; i++ {
		nums[i], nums[len(nums)-1-i] = nums[len(nums)-1-i], nums[i]
	}
}
