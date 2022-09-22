package 数组

func findDisappearedNumbers(nums []int) []int {
	n := len(nums)
	var res []int
	seen := map[int]bool{}
	for i := 0; i < len(nums); i++ {
		seen[nums[i]] = true
	}
	for i := 1; i <= n; i++ {
		if !seen[i] {
			res = append(res, i)
		}
	}
	return res
}
