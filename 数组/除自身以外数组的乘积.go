package 数组

//巨简单的动态规划，我不屑于写进动态规划专题里面
func productExceptSelf(nums []int) []int {
	n := len(nums)
	left := make([]int, len(nums)) //left[i] :nums[i]开始，不取nums[i],左边的元素之积
	right := make([]int, len(nums))
	left[0] = 1
	right[n-1] = 1
	for i := 1; i < n; i++ {
		left[i] = left[i-1] * nums[i-1]
		right[n-1-i] = right[n-i] * nums[n-i]
	}
	var res []int
	for i := 0; i < n; i++ {
		res = append(res, left[i]*right[i])
	}
	return res
}
