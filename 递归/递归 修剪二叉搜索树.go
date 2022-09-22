package 递归

func trimBST(root *TreeNode, low int, high int) *TreeNode {
	if root == nil {
		return nil
	}

	if root.Val >= low && root.Val <= high { //当我的值在low与high之间时，修剪左边右边，并用自己的左右手接住
		root.Left = trimBST(root.Left, low, high) //root.Left 接入符合条件的左孩子
		root.Right = trimBST(root.Right, low, high)
	}

	if root.Val < low { //我的值比low小，我左边的值更比low小了，左边全体数据无效，只修剪右边
		return trimBST(root.Right, low, high) //直接修剪右子树，左边全体忽略不计
	}

	if root.Val > high { //我的值比high大，我右边的值比high更大，右边全体数据忽略不计，只修剪左边
		return trimBST(root.Left, low, high)
	}

	return root
}
