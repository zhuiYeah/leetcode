package 动态规划

//你是个小偷，不能偷盗相邻的房屋，你能偷盗的最大数量财产是多少

func rob(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	n := len(nums)       // 一共有n户人家
	dp := make([]int, n) // dp[i] : 偷窃下标为0～i的人家 所能偷窃的最大值
	//递推公式: dp[i] = max(dp[i-1],dp[i-2]+nums[i])
	//对于第i户人家，只有两种选择，偷和不偷
	//不偷 当前偷窃的最大价值为 dp[i-1]
	//偷  当前偷窃的最大价值为 dp[i-2] + nums[i]

	//初始化dp数组
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])
	for i := 2; i < n; i++ {
		dp[i] = max(dp[i-1], dp[i-2]+nums[i])
	}

	return dp[n-1]
}
