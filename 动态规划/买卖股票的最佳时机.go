package 动态规划

//
func maxProfit(prices []int) int {
	dp := make([][]int, len(prices))
	//dp[i][0]:第i天持有股票  手上的最大金额  第i天的股票从哪来的：1⃣️第i-1天就有，继承dp[i-1][0] 2⃣️i天买入的 -prices[i]
	//dp[i][1]:第i天不持有股票 手上的的最大金额
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}
	//第i天持有股票时候的负债，要么买入第i天的股票（-price[i]）;要么第i天不买入，之前就已经持有股票了了,继承之前持有股票的状态 dp[i-1][0]
	//dp[i][0]= max(-price[i],dp[i-1][0])
	//第i天不持有股票的时候的收益，要么当天卖出股票（前一天一定是持有股票的状态）：price[i]+dp[i-1][0];要么当天不卖（你也没得卖），继承前一天不持有股票的状态dp[i-1][1] {不持有股票有两种情况，一种是一直就没买入也没卖出，一种是早就买入了也已经卖出了}
	dp[0][0] = -prices[0]
	dp[0][1] = 0
	for i := 1; i < len(dp); i++ { //遍历天数
		dp[i][0] = max(-prices[i], dp[i-1][0])
		dp[i][1] = max(prices[i]+dp[i-1][0], dp[i-1][1])
	}
	return dp[len(dp)-1][1]
}

//优化一下空间复杂度
func maxProfit0(prices []int) int {
	var dp [2]int
	//第i天持有股票时候的负债，要么买入第i天的股票（-price[i]）;要么第i天不买入，之前就已经持有股票了了,继承之前持有股票的状态 dp[i-1][0]
	//dp[i][0]= max(-price[i],dp[i-1][0])
	//第i天不持有股票的时候的收益，要么当天卖出股票（前一天一定是持有股票的状态）：price[i]+dp[i-1][0];要么当天不卖（你也没得卖），继承前一天不持有股票的状态dp[i-1][1] {不持有股票有两种情况，一种是一直就没买入也没卖出，一种是早就买入了也已经卖出了}
	dp[0] = -prices[0]
	dp[1] = 0
	for i := 1; i < len(prices); i++ { //遍历天数
		dp[1] = max(prices[i]+dp[0], dp[1])
		dp[0] = max(-prices[i], dp[0])

	}
	return dp[1]
}
