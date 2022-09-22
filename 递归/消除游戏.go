package 递归

//超时，本题是数学问题
func lastRemaining(n int) int {
	var nums []int
	for i := 1; i <= n; i++ {
		nums = append(nums, i)
	}
	var deleteNums func(nums []int) []int
	deleteNums = func(nums []int) []int {
		if len(nums) == 1 {
			return []int{nums[0]}
		}
		var next []int
		x := len(nums) % 2 //奇数个就从倒数第二个取，偶数个就从倒数第一个取
		for i := len(nums) - 1 - x; i >= 0; i -= 2 {
			next = append(next, nums[i])
		}
		return deleteNums(next)
	}

	return deleteNums(nums)[0]
}
