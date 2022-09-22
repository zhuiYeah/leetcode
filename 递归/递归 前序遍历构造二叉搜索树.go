package 递归

import (
	"fmt"
	"sort"
)

func bstFromPreorder(preorder []int) *TreeNode {
	var inorder []int
	for i := 0; i < len(preorder); i++ {
		inorder = append(inorder, preorder[i])
	} //如果用inorder:=preorder,再sort（inorder），会直接导致preorder被更改。并且cap的更改也影响了树的构造。
	sort.Ints(inorder)

	var buildTree func([]int, []int) *TreeNode
	buildTree = func(pre []int, in []int) *TreeNode { //从前序遍历和中序遍历构造二叉树
		if len(pre) == 0 {
			return nil
		}
		root := &TreeNode{pre[0], nil, nil}
		i := 0
		for ; i < len(in); i++ {
			if in[i] == pre[0] {
				break
			}
		}
		lenOfLeftSub := i
		root.Left = buildTree(pre[1:1+lenOfLeftSub], in[:lenOfLeftSub])
		root.Right = buildTree(pre[1+lenOfLeftSub:], in[1+lenOfLeftSub:])

		return root
	}
	root := buildTree(preorder, inorder)
	return root
}

func main() {
	x := []int{5, 6, 7, 3, 4, 21, 7}
	var y []int

	for i := 0; i < len(x); i++ {
		y = append(y, x[i])
	}

	sort.Ints(y)

	fmt.Printf("%v\n", y)

	//p := []int{4, 2}
	//bstFromPreorder(p)
}
