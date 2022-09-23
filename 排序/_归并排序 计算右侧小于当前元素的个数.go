package 排序

func countSmaller(nums []int) []int {
	res := []int{}

	for i := 0; i < len(nums)-1; i++ {
		num := 0
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[i] {
				num++
			}
		}
		res = append(res, num)
	}
	res = append(res, 0)
	return res
}
