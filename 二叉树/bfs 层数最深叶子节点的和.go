package 二叉树

func deepestLeavesSum0(root *TreeNode) int {
	var res int
	queue := []*TreeNode{root}
	for len(queue) != 0 {
		n := len(queue)
		curLayerSum := 0
		for i := 0; i < n; i++ {
			cur := queue[0]
			queue = queue[1:]
			curLayerSum += cur.Val
			if cur.Left != nil {
				queue = append(queue, cur.Left)
			}
			if cur.Right != nil {
				queue = append(queue, cur.Right)
			}
		}
		res = curLayerSum
	}
	return res
}
