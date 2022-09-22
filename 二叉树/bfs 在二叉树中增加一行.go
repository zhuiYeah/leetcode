package 二叉树

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
	if depth == 1 {
		return &TreeNode{val, root, nil}
	}
	queue := []*TreeNode{root}
	curDepth := 2
	for curDepth < depth {
		n := len(queue)
		for i := 0; i < n; i++ {
			cur := queue[0]
			queue = queue[1:]
			if cur.Left != nil {
				queue = append(queue, cur.Left)
			}
			if cur.Right != nil {
				queue = append(queue, cur.Right)
			}
		}
		curDepth++
	}
	//当前queue中保存着所有的第depth-1层的节点
	for i := 0; i < len(queue); i++ {
		tmp1 := queue[i].Left
		tmp2 := queue[i].Right
		queue[i].Left = &TreeNode{val, tmp1, nil}
		queue[i].Right = &TreeNode{val, nil, tmp2}
	}
	return root
}
