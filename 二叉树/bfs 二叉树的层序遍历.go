package 二叉树

import "fmt"

func levelOrder0(root *TreeNode) [][]int {
	var res [][]int
	queue := []*TreeNode{root}

	for len(queue) != 0 { //每次进入这一循环，代表某一层的遍历已经结束
		n := len(queue) //当前层的总节点数

		res = append(res, []int{})

		for i := 0; i < n; i++ { //进入这一循环，代表遍历当前层
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			res[len(res)-1] = append(res[len(res)-1], node.Val)
		}
	}
	return res
}

func main() {
	var a [][]int
	a = append(a, []int{0})
	a = append(a, []int{})
	a[len(a)-1] = append(a[len(a)-1], 23)
	a[len(a)-1] = append(a[len(a)-1], 30)
	fmt.Printf("%v\n", a)
}
