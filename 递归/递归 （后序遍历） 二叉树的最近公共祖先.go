package 递归

//后序遍历是一种天然的回溯，后序遍历最先处理的一定是叶子节点
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode { //从root开始，找到 p，q的公共祖先
	if root == nil {
		return nil
	}

	if root.Val == p.Val || root.Val == q.Val {
		return root
	}

	//这种先用left，right接住左子树右子树的返回值之后再对其进行分析处理的方法是一种遍历整棵树的写法，与之对应的是搜索一条边的写法
	left := lowestCommonAncestor(root.Left, p, q)   //如果left不为nil，那么左子树包含p/q
	right := lowestCommonAncestor(root.Right, p, q) //如果right不为nil，那么右子树包含p/q

	//目前在root节点，遍历完root节点的左子树和右子树之后，知道了左子树和右子树是否包含p q节点，下面还要通过对left和right的分析来确定返回的公共祖先是谁

	if left != nil && right != nil { //左子树包含p/q，右子树包含p/q，那么root这一点一定是公共祖先，至于是不是最近公共祖先，由于我们采用的后序遍历，所以是的
		return root
	}

	if left != nil { //左子树包含了p、q，右子树啥也不包含  ，
		return left
	}
	if right != nil { //右子树包含了p、q，左子树啥也不包含
		return right
	}

	return nil //左右子树都不包含 p、q
}
