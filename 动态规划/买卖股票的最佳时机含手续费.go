package 动态规划

//每次交易你需要付出手续费fee

func maxProfit6(prices []int, fee int) int {
	dp := make([][]int, len(prices))
	//dp[i][0] : 第i天，手中持有股票 手中的最大金额   1⃣️ 第i-1天就持有股票 ，继承dp[i-1][0]  2⃣️ 第i-1天不持有股票，当天买入股票 dp[i-1][1]-prices[i]
	//dp[i][0] = max{dp[i-1][0] ,dp[i-1][1]-prices[i]}

	//dp[i][1]:第i天，手中不持有股票，手中的最大金额  1⃣️第i-1天持有股票，当天卖出 dp[i-1][0]+prices[i]-fee  2⃣️ 第i-1天不持有股票，直接继承 dp[i-1][1]
	//dp[i][1] = max{dp[i-1][0]+prices[i]-fee,dp[i-1][1]}
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}

	//初始化dp数组
	dp[0][0] = -prices[0]
	dp[0][1] = 0
	for i := 1; i < len(prices); i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i])
		dp[i][1] = max(dp[i-1][0]+prices[i]-fee, dp[i-1][1])
	}
	return dp[len(dp)-1][1]
}

//优化了复杂度
func maxProfit66(prices []int, fee int) int {
	dp := make([]int, 2)
	dp[0] = -prices[0]
	dp[1] = 0
	for i := 1; i < len(prices); i++ {
		x0 := dp[0]
		dp[0] = max(dp[0], dp[1]-prices[i])
		dp[1] = max(x0+prices[i]-fee, dp[1])
	}
	return dp[1]
}
