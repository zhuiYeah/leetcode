package 二叉树

import "math"

//二叉搜索树转换为链表
//原址修改,不可以中序遍历树获得一个数组然后再对这个数组构造链表哦
func convertBiNode(root *TreeNode) *TreeNode {
	fakeRoot := &TreeNode{math.MinInt32, nil, nil}
	tmp := fakeRoot

	var dfs func(root *TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}

		dfs(root.Left)
		//这是个彻彻底底的中序遍历的逻辑
		tmp.Right = root
		tmp = tmp.Right
		root.Left = nil
		dfs(root.Right)
	}

	dfs(root)
	return fakeRoot.Right
}
