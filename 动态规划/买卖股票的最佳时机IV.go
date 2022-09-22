package 动态规划

//你最多完成k次交易

func maxProfit4(k int, prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	dp := make([][]int, len(prices))
	//dp[i][0] ： 第i天啥都不做，并且之前没有进行过任何一次交易，手中的最大金额为dp[i][0] // 任何时刻 ，dp[i][0]都是0
	//dp[i][j] :  j为奇数时： 第i天是第（j+1)/2次买入股票或...。1⃣️第i天买入股票 dp[i-1][j-1]-prices[i]  2⃣️第i天继承i-1天已经买入股票的状态dp[i-1][j]
	//dp[i][j]: j为偶数时：第i天是卖出股票或...。   1⃣️第i天卖出股票 dp[i-1][j-1]+prices[i]  2⃣️第i天继承i-1天已经卖出股票的状态dp[i-1][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2*k+1)
	}
	//初始化dp数组
	for i := 1; i <= 2*k; i += 2 {
		dp[0][i] = -prices[0]
	}

	for i := 1; i < len(dp); i++ { //先遍历天数
		for j := 1; j <= 2*k; j++ { //再遍历当天的买入卖出情况
			if j%2 == 1 {
				dp[i][j] = max(dp[i-1][j-1]-prices[i], dp[i-1][j])
			} else {
				dp[i][j] = max(dp[i-1][j-1]+prices[i], dp[i-1][j])
			}
		}
	}

	return dp[len(dp)-1][2*k]
}

//优化空间复杂度
func maxProfit44(k int, prices []int) int {
	dp := make([]int, 2*k+1)
	for i := 1; i <= 2*k; i += 2 {
		dp[i] = -prices[0]
	}
	for i := 1; i < len(prices); i++ {
		for j := 2 * k; j > 0; j-- {
			if j%2 == 1 {
				dp[j] = max(dp[j-1]-prices[i], dp[j])
			} else {
				dp[j] = max(dp[j-1]+prices[i], dp[j])
			}
		}
	}
	return dp[len(dp)-1]
}
