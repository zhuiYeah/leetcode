package 单调栈

import "math"

//nums是首尾相接的，找到nums中每一个元素的下一个更大元素

func nextGreaterElements(nums []int) []int {
	max := math.MinInt32
	for i := 0; i < len(nums); i++ {
		if nums[i] > max {
			max = nums[i]
		}
	}
	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if nums[i] == max {
			res[i] = -1
		}
	}
	stack := []int{}          //这个栈储存nums元素的下标哈
	for k := 0; k <= 1; k++ { //遍历数组nums两次，你就足以得到你想要的东西了
		for i := 0; i < len(nums); i++ {
			for len(stack) != 0 && nums[i] > nums[stack[len(stack)-1]] {
				res[stack[len(stack)-1]] = nums[i]
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
	}
	return res
}
