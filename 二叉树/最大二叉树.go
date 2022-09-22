package 二叉树

//这题秒杀了

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	maxIndex := 0
	maxNum := nums[0]
	for i := 1; i < len(nums); i++ { //找到数组最大值的下标
		if nums[i] > maxNum {
			maxNum = nums[i]
			maxIndex = i
		}
	}
	root := &TreeNode{nums[maxIndex], nil, nil}
	root.Left = constructMaximumBinaryTree(nums[:maxIndex])
	root.Right = constructMaximumBinaryTree(nums[maxIndex+1:])
	return root
}
