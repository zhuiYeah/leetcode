package 动态规划

//你最多完成两笔交易

//难点在于，我可以进行两次交易，可以进行一次交易，也可以一次交易都不做
func maxProfit3(prices []int) int {
	dp := make([][]int, len(prices))
	//dp[i][0]:第i天我啥也不做；手中的最大金额数量
	//dp[i][1]:第i天进行第一次买入；或者在第i天之前已经完成了第一次买入，且i天仍保持着第一次买入之后的状态 ； 手中的最大金额数量为dp[i][1]
	//dp[i][2]:第i天进行第一次卖出；或者在第i天之前已经完成了第一次卖出，且i天仍保持着第一次卖出之后的状态 ； 手中的最大金额数量
	//dp[i][3]:第i天进行第二次买入；或者在第i天之前已经完成了第二次买入，且第二天仍保持着第二次买入后的状态 ； 手中的最大金额数量
	//dp[i][4]:第i天进行第二次卖出；或者在dii天之前已经完成了第二次卖出，且第i天仍保持着第二次卖出之后的状态； 手中的最大金额数量
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 5)
	}
	//dp[i][0]=0
	//dp[i][1]:1⃣️就在当天进行第一次买入 -prices[i]	2⃣️继承i-1天买入的状态 dp[i-1][1]
	//so dp[i][1]=max(-prices[i],dp[i-1][1])
	//dp[i][2]:1⃣️就在当天进行第一次卖出 dp[i-1][1]+prices[i] 2⃣️继承i-1天卖出的状态dp[i-1][2]
	//so dp[i][2]=max(dp[i-1][1]+prices[i],dp[i-1][2])
	//dp[i][3]:1⃣️就在当天进行第二次买入 dp[i-1][2]-prices[i] 2⃣️继承i-1天第二次买入的状态dp[i-1][3]
	//dp[i][4]:1⃣️就在当天进行第二次卖出 dp[i-1][3]+prices[i] 2⃣️继承i-1天第二次卖出的状态dp[i-1][4]

	dp[0][1] = -prices[0]
	dp[0][2] = 0
	dp[0][3] = -prices[0]
	dp[0][4] = 0

	for i := 1; i < len(prices); i++ { //遍历天数
		dp[i][1] = max(-prices[i], dp[i-1][1])
		dp[i][2] = max(dp[i-1][1]+prices[i], dp[i-1][2])
		dp[i][3] = max(dp[i-1][2]-prices[i], dp[i-1][3])
		dp[i][4] = max(dp[i-1][3]+prices[i], dp[i-1][4])
	}

	return dp[len(dp)-1][4]
}

//优化空间复杂度
func maxProfit33(prices []int) int {
	dp := [5]int{}
	dp[1] = -prices[0]
	dp[2] = 0
	dp[3] = -prices[0]
	dp[4] = 0

	for i := 1; i < len(prices); i++ { //遍历天数
		dp[4] = max(dp[3]+prices[i], dp[4])
		dp[3] = max(dp[2]-prices[i], dp[3])
		dp[2] = max(dp[1]+prices[i], dp[2])
		dp[1] = max(-prices[i], dp[1])
	}
	return dp[4]
}
