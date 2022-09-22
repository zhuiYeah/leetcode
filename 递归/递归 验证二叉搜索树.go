package 递归

import (
	"fmt"
	"math"
)

//方法一，中序遍历必定为升序
func isValidBST0(root *TreeNode) bool {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return true
	}
	x := []int{}
	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		inorder(node.Left)
		x = append(x, node.Val)
		inorder(node.Right)
	}
	inorder(root)
	fmt.Printf("%v\n", x)
	for i := 0; i < len(x)-1; i++ {
		if x[i] > x[i+1] {
			return false
		}
	}
	return true
}

//方法二，纯递归
func isValidBST(root *TreeNode) bool {
	return ewqrwq(root, math.MinInt, math.MaxInt)
}

func ewqrwq(node *TreeNode, low int, high int) bool { //判断一个节点是否为BST
	if node == nil {
		return true
	}
	if node.Val <= low || node.Val >= high { //任意节点的值都必须在low与high之间
		return false
	}

	//左节点的值必须小于node.Val ,右节点的值必须大于node.Val
	return ewqrwq(node.Left, low, node.Val) && ewqrwq(node.Right, node.Val, high)
}
