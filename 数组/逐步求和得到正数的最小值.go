package 数组

//累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue
//这就是前缀和？ 前缀和就这？
func minStartValue(nums []int) int {
	startValue := 1
	sum := 0
	for i := 0; i < len(nums); i++ {
		tmp := nums[i]
		nums[i] += sum
		sum += tmp
		if startValue+nums[i] <= 0 {
			startValue = -(nums[i] - 1)
		}
	}
	return startValue
}
