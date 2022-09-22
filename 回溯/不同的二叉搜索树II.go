package 回溯

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//给出所有的从1～n构成的不同的二叉搜索树的根节点
//写了非常久  超过14% 😭
func generateTrees(n int) []*TreeNode {
	var res []*TreeNode
	lenOfTree := 0                        //表示当前二叉搜索树的节点个数
	visited := make([]bool, n+1)          //visited[n]==true 就表明这个数字n已经插入了二叉搜索树了
	fakeRoot := &TreeNode{-123, nil, nil} //二叉搜索树的伪根节点 ,类似于链表的伪头节点的作用
	var backtracking func()
	backtracking = func() {
		if lenOfTree == n { //叶子节点
			tmp := copyTree(fakeRoot.Right)
			if !hasSameTree(res, tmp) { //没办法 ， 最low的结果去重
				res = append(res, tmp)
			}
			return
		}

		for i := 1; i <= n; i++ {
			//选择val[i]
			if visited[i] == false {
				fakeRoot = BSTinsertion(fakeRoot, i)
				visited[i] = true
				lenOfTree++
			} else {
				continue
			}
			//往下进一层，是否到达叶子结点
			backtracking()
			//回溯阶段
			lenOfTree--
			visited[i] = false
			fakeRoot = BSTdelete(fakeRoot, i)
		}
	}
	backtracking()
	return res
}

// BSTinsertion 往二叉树中插入值val
func BSTinsertion(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{val, nil, nil}
	}
	if val > root.Val {
		root.Right = BSTinsertion(root.Right, val)
	}
	if val < root.Val {
		root.Left = BSTinsertion(root.Left, val)
	}
	return root
}

// BSTdelete 二叉树删除值为val的节点已经这个节点的所有子树
func BSTdelete(root *TreeNode, val int) *TreeNode {
	if root == nil || root.Val == val {
		return nil
	}
	if val > root.Val {
		root.Right = BSTdelete(root.Right, val)
	} else if val < root.Val {
		root.Left = BSTdelete(root.Left, val)
	}
	return root
}

//深复制一颗二叉树
func copyTree(root *TreeNode) *TreeNode { //复制一颗二叉树 ，深复制
	if root == nil {
		return nil
	}
	node := &TreeNode{root.Val, nil, nil}
	node.Left = copyTree(root.Left)
	node.Right = copyTree(root.Right)
	return node
}

func hasSameTree(res []*TreeNode, tmp *TreeNode) bool {
	for i := 0; i < len(res); i++ {
		if isSameTree(res[i], tmp) {
			return true
		}
	}
	return false
}

func isSameTree(p, q *TreeNode) bool { //判断两颗二叉树是否完全相同
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
