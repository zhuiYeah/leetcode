package 二叉树

//判断B是不是A的子结构

///纯纯的脑摊写法
//func isSubStructure(A *TreeNode, B *TreeNode) bool {
//	if B == nil {
//		return false
//	}
//	var res bool
//	var dfs func(A, B *TreeNode)
//	dfs = func(A, B *TreeNode) {
//		if A == nil {
//			return
//		}
//		if A.Val == B.Val {
//			if compare(A, B) {
//				res = true
//			}
//		}
//		dfs(A.Left, B)
//		dfs(A.Right, B)
//	}
//	dfs(A,B)
//	return res
//}
//
//func compare(A, B *TreeNode) bool {
//	if A == nil && B == nil {
//		return true
//	}
//	if A != nil && B == nil {
//		return true
//	}
//	if A == nil && B != nil {
//		return false
//	}
//	if A.Val != B.Val {
//		return false
//	}
//	if !compare(A.Left, B.Left) {
//		return false
//	}
//	if !compare(A.Right, B.Right) {
//		return false
//	}
//	return true
//}

//B是不是A的某一个子结构:
//第一步：B是不是A的子结构
//第二步：B是不是A的左子树的子结构
//第三部：B是不是A的右子树的子结构
func isSubStructure0(A *TreeNode, B *TreeNode) bool {
	//如果A为空或者B为空，那么B一定不是A的子结构
	if B == nil || A == nil {
		return false
	}
	//此时A，B必定都不为空
	//第一步：B是不是A的子结构
	if compare(A, B) {
		return true
	}
	//第二步：B是不是A的左子树的子结构
	if isSubStructure(A.Left, B) {
		return true
	}
	//第三部：B是不是A的右子树的子结构
	if isSubStructure(A.Right, B) {
		return true
	}
	return false
	//从61行到72行的代码可以被简化为一行  return compare(A,B) || isSubStructure()   ||
	//这种简化适用于有一个true那就本函数就可以返回true ，有一个对，全局对
}

func compare0(A, B *TreeNode) bool {
	if A == nil && B == nil {
		return true
	}
	if A == nil && B != nil {
		return false
	}
	if A != nil && B == nil {
		return true
	}
	if A.Val != B.Val {
		return false
	}
	//以上代码可以简化为两个if
	if !compare(A.Left, B.Left) {
		return false
	}
	if !compare(A.Right, B.Right) {
		return false
	}
	return true
	//以上代码可以简化为一行  return compare(A.Left,B.Left) && compare(A.Right,B.Right)
	////这种简化适用于有一个false那就本函数就可以返回false ， 有一个错，全局错
}

//超级进阶版，逻辑相同，代码究极简化版
func isSubStructure(A *TreeNode, B *TreeNode) bool {
	//如果A为空或者B为空，那么B一定不是A的子结构
	if B == nil || A == nil {
		return false
	}
	////此时A，B必定都不为空
	////第一步：B是不是A的子结构
	//if compare(A, B) {
	//	return true
	//}
	////第二步：B是不是A的左子树的子结构
	//if isSubStructure(A.Left, B) {
	//	return true
	//}
	////第三部：B是不是A的右子树的子结构
	//if isSubStructure(A.Right, B) {
	//	return true
	//}
	//return false
	return compare(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
	//这种简化适用于有一个true那就本函数就可以返回true ，有一个对，全局对

}

func compare(A, B *TreeNode) bool {
	if B == nil {
		return true
	}
	if A == nil || A.Val != B.Val {
		return false
	}
	//if !compare(A.Left, B.Left) {
	//	return false
	//}
	//if !compare(A.Right, B.Right) {
	//	return false
	//}
	//return true
	return compare(A.Left, B.Left) && compare(A.Right, B.Right)
	///这种简化适用于有一个false那就本函数就可以返回false ， 有一个错，全局错
}
