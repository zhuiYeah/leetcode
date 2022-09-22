package 单调栈

//nums1中的每一个数都能在nums2中找到 ， 找到nums1[i]在nums2中的下一个更大元素

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	nextLargerElement := map[int]int{}
	stack := []int{nums2[0]}
	for i := 1; i < len(nums2); i++ {
		for len(stack) != 0 && nums2[i] > stack[len(stack)-1] {
			end := len(stack) - 1
			nextLargerElement[stack[end]] = nums2[i]
			stack = stack[:end]
		}
		stack = append(stack, nums2[i])
	}
	for i := 0; i < len(stack); i++ {
		nextLargerElement[stack[i]] = -1
	}
	for i := 0; i < len(nums1); i++ {
		nums1[i] = nextLargerElement[nums1[i]]
	}
	return nums1
}
