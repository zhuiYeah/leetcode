package 回溯

//1+1+1+1-1=3
//1-1+1+1+1=3
//超过5% 牛啊
func findTargetSumWays(nums []int, target int) int {
	res := 0
	SUM := 0
	for i := 0; i < len(nums); i++ {
		SUM += nums[i]
	}
	var backtracking func(startIndex int, sum int)
	backtracking = func(startIndex int, sum int) {
		if startIndex == len(nums) && sum == target { //叶子节点
			res++
			return
		}
		if startIndex == len(nums) {
			return
		}

		for i := 0; i < 2; i++ { //每一层只有两种处理情况，加或者减
			if i == 0 {
				sum += nums[startIndex]
			} else {
				sum -= nums[startIndex]
			}
			//
			backtracking(startIndex+1, sum)
			//回溯
			if i == 0 {
				sum -= nums[startIndex]
			} else {
				sum += nums[startIndex]
			}
		}
	}
	backtracking(0, 0)
	return res
}
