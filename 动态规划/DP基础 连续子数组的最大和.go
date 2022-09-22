package 动态规划

func maxSubArray(nums []int) int {
	dp := make([]int, len(nums))
	//dp[i] : 从nums0～numsi，子数组一定要取nums[i],取完nums[i]之后 最大子数组和为dp[i]
	dp[0] = nums[0]
	res := dp[0]
	//到达nums[i]时，有两个选择 1⃣️子数组取nums[i]  2⃣️从头开始一个子数组，numsi作为第一个元素
	//dp[i] = max(dp[i-1]+nums[i],nums[i])
	for i := 1; i < len(dp); i++ {
		dp[i] = max(dp[i-1]+nums[i], nums[i])
		if dp[i] > res {
			res = dp[i]
		}
	}

	return res
}
