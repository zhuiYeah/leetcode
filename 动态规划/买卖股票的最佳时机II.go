package 动态规划

//你可以进行任意次数的交易

func maxProfit1(prices []int) int {
	dp := make([][]int, len(prices))
	//dp[i][0] : 第i天，持有股票的情况下，手中的最大金额数量
	//dp[i][1] : 第i天，不持有股票的情况下，手中的最大金额数量
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}

	//状态转移公式的推导过程 当前已经到了第i天了

	//第i天，我手里可以选择持有股票 dp[i][0]
	//dp[i][0]可以从两个状态推导而来：第i-1天持有股票dp[i-1][0]；第i-1天不持有股票dp[i-1][1]
	//第i-1天持有股票时，第i天啥也不用做，直接继承dp[i-1][0],试想一下如果当天卖出手里的股票又买进一支股票，那是无意义的
	//第i-1天不持有股票时，第i天就必须买入股票，dp[i-1][1]+prices[i]
	//所以 dp[i][0]=max{dp[i-1][0],dp[i-1][1]+prices[i]}

	//第i天，我手里可以选择不持有股票 dp[i][1]
	//同样的，dp[i][1]可以从两个状态推导而来：第i-1天持有股票dp[i-1][0]；第i-1天不持有股票dp[i-1][1]
	//第i-1天持有股票时，第i天必须卖出股票，dp[i-1][0]+prices[i]
	//第i-1天不持有股票时，第i天啥也不用做，直接继承dp[i-1][1]
	//dp[i][1]=max{dp[i-1][1],dp[i-1][0]+prices[i]}

	dp[0][0] = -prices[0]
	dp[0][1] = 0
	for i := 1; i < len(dp); i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i])
	}
	return dp[len(dp)-1][1]
}

//优化空间复杂度
func maxProfit2(prices []int) int {
	dp := make([]int, 2)

	dp[0] = -prices[0]
	dp[1] = 0
	for i := 1; i < len(prices); i++ {
		x := dp[0]
		dp[0] = max(dp[0], dp[1]-prices[i])
		dp[1] = max(dp[1], x+prices[i])
	}
	return dp[1]
}
