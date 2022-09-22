package 二叉树

type CBTInserter struct {
	queue []*TreeNode //采用数组储存二叉树，方便检索一个节点的父节点
}

func Constructor0(root *TreeNode) CBTInserter {
	//层序遍历root二叉树，构建一个root二叉树的数组储存形式
	tmp := []*TreeNode{root}
	var queue []*TreeNode
	for len(tmp) != 0 {
		cur := tmp[0]
		tmp = tmp[1:]
		queue = append(queue, cur)
		if cur.Left != nil {
			tmp = append(tmp, cur.Left)
		}
		if cur.Right != nil {
			tmp = append(tmp, cur.Right)
		}
	}
	return CBTInserter{queue}
}

func (this *CBTInserter) Insert(val int) int {
	n := len(this.queue) //n就是新插入的节点在数组中的下标
	tmp := &TreeNode{val, nil, nil}
	this.queue = append(this.queue, tmp)
	father := this.queue[(n-1)/2]
	if father.Left == nil {
		father.Left = tmp
	} else {
		father.Right = tmp
	}
	return father.Val
}

func (this *CBTInserter) Get_root() *TreeNode {
	return this.queue[0]
}
