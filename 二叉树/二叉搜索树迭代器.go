package 二叉树

type BSTIterator struct {
	ptr  int
	nums []int
}

func Constructor(root *TreeNode) BSTIterator {
	var xx []int
	xx = append(xx, -114514)
	var inorder func(root *TreeNode)
	inorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		inorder(root.Left)
		xx = append(xx, root.Val)
		inorder(root.Right)
	}
	inorder(root)
	return BSTIterator{0, xx}
}

func (this *BSTIterator) Next() int {
	this.ptr++
	return this.nums[this.ptr]
}

func (this *BSTIterator) HasNext() bool {
	if this.ptr == len(this.nums)-1 {
		return false
	} else {
		return true
	}
}
