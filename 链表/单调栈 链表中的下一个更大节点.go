package 链表

//维护一个小顶栈
func nextLargerNodes(head *ListNode) []int {
	var nums []int
	for head != nil {
		nums = append(nums, head.Val)
		head = head.Next
	}
	res := make([]int, len(nums))
	stack := []int{0} //栈储存元素的下标
	for i := 1; i < len(nums); i++ {
		if nums[i] <= nums[stack[len(stack)-1]] { //当前元素i比栈顶元素小？ 当前元素立刻入栈
			stack = append(stack, i)
		} else {
			for len(stack) != 0 && nums[i] > nums[stack[len(stack)-1]] {
				res[stack[len(stack)-1]] = nums[i] //找到栈顶元素的下一个更大元素了，即nums[i]
				stack = stack[:len(stack)-1]       //栈顶元素出栈
			}
			stack = append(stack, i)
		}
	}
	return res
}
