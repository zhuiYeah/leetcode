package 单调栈

func findUnsortedSubarray(nums []int) int {
	stack := []int{0} //维护一个大顶栈，栈中存的是下标
	start := len(nums)
	end := 0
	for i := 1; i < len(nums); i++ {
		for len(stack) != 0 && nums[i] <= nums[stack[len(stack)-1]] { //为了维护大顶栈，nums[i] 必须要 换掉栈顶的元素
			start = min(start, stack[len(stack)-1])
			end = i
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	res := end - start + 1
	if res < 0 {
		return 0
	}
	return res
}
