package 二叉树

//后序遍历数组的最后一个数字一定是根节点，前面部分是左子树的后序遍历、右子树的后序遍历
//而二叉搜索树，左子树一定小、右子树一定大
func verifyPostorder(postorder []int) bool { //判断一个序列是不是二叉搜索树序列
	if len(postorder) == 0 || len(postorder) == 1 {
		return true
	}
	rootNum := postorder[len(postorder)-1]
	postorder = postorder[:len(postorder)-1]
	var startOfRight int
	for startOfRight = 0; startOfRight < len(postorder); startOfRight++ {
		if postorder[startOfRight] > rootNum {
			break
		}
	}
	//startOfRight目前指向比rootNum大的第一个数字，即右子树的后序遍历的第一个结果
	for i := startOfRight; i < len(postorder); i++ {
		if postorder[i] < rootNum { //右子树居然比跟节点小，那必定不是二叉搜索树了
			return false
		}
	}

	return verifyPostorder(postorder[:startOfRight]) && verifyPostorder(postorder[startOfRight:])
	//if !verifyPostorder(postorder[:startOfRight]) {
	//	return false
	//}
	//if !verifyPostorder(postorder[startOfRight:]) {
	//	return false
	//}
	//return true
	//对以上进行简化 ，有一段不对，那就全错的逻辑  参考 *树的子结构
}
