package 二叉树

type ListNode struct {
	Val  int
	Next *ListNode
}

//秒杀
func sortedListToBST(head *ListNode) *TreeNode {
	var arr []int
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	var arrToBST func([]int) *TreeNode

	arrToBST = func(nums []int) *TreeNode {
		if len(nums) == 0 {
			return nil
		}
		mid := len(nums) / 2
		node := &TreeNode{nums[mid], nil, nil}
		node.Left = arrToBST(nums[0:mid])
		node.Right = arrToBST(nums[mid+1 : len(nums)])
		return node
	}

	return arrToBST(arr)
}
