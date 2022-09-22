package 动态规划

func minCost(costs [][]int) int {
	m := len(costs) //表示一共有m个房子
	dp := make([][]int, m)
	//dp[i][j],目前粉刷到第i个房子，如果选择粉刷j颜色，那么所需要的最小开销为dp[i][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 3)
	}
	for j := 0; j < 3; j++ {
		dp[0][j] = costs[0][j]
	}
	for i := 1; i < m; i++ {
		for j := 0; j < 3; j++ {
			if j == 0 {
				dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + costs[i][j]
			} else if j == 2 {
				dp[i][j] = min(dp[i-1][1], dp[i-1][0]) + costs[i][j]
			} else {
				dp[i][j] = min(dp[i-1][0], dp[i-1][2]) + costs[i][j]
			}
		}
	}
	return min(dp[m-1][0], min(dp[m-1][1], dp[m-1][2]))
}
func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
