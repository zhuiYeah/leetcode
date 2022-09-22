package 数组

//找到数组中的数量大于n/2的元素
func majorityElement(nums []int) int {

	seen := map[int]int{}
	for i := 0; i < len(nums); i++ {
		seen[nums[i]]++
		if seen[nums[i]] > len(nums)/2 {
			return nums[i]
		}
	}
	return -123
}
