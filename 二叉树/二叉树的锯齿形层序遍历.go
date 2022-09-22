package 二叉树

func zigzagLevelOrder(root *TreeNode) [][]int {
	var res [][]int
	queue := []*TreeNode{root}
	for len(queue) != 0 {
		n := len(queue)
		var tmp []int
		for i := 0; i < n; i++ {
			cur := queue[0]
			queue = queue[1:]
			tmp = append(tmp, cur.Val)
			if cur.Left != nil {
				queue = append(queue, cur.Left)
			}
			if cur.Right != nil {
				queue = append(queue, cur.Right)
			}
		}
		res = append(res, tmp)
	}
	for i := 1; i < len(res); i += 2 {
		reverse(res[i])
	}
	return res
}

func reverse(x []int) {
	for i := 0; i < len(x)/2; i++ {
		x[i], x[len(x)-1-i] = x[len(x)-1-i], x[i]
	}
}
