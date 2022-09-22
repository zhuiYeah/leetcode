package 动态规划

func minCostClimbingStairs(cost []int) int {
	n := len(cost)
	dp := make([]int, n) //dp[i]:踩上第i层楼梯，需要的最小开销
	//递推公式：dp[i]=min(dp[i-1],dp[i-2])+1
	//初始化dp数组
	dp[0] = cost[0]
	dp[1] = cost[1]

	for i := 2; i < len(dp); i++ {
		dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
	}

	return min(dp[n-1], dp[n-2])
}
